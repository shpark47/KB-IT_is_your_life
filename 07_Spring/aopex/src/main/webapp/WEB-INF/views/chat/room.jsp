<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>${room.roomName} - 채팅방</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- 수업과 동일한 StompJs 라이브러리 -->
    <script src="https://cdn.jsdelivr.net/npm/@stomp/stompjs@7.0.0/bundles/stomp.umd.min.js"></script>

    <style>
        body { padding: 30px; }
        .chat-container { max-height: 400px; overflow-y: auto; border: 1px solid #ddd; padding: 10px; }
        .info-message { font-style: italic; color: #777; }
        .message-time { font-size: 0.8em; margin-right: 5px; }
        .connection-status { margin-top: 10px; font-weight: bold; }
    </style>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>💬 ${room.roomName}
            <small><a href="/chat/rooms" class="btn btn-default btn-sm">← 목록으로</a></small>
        </h1>
    </div>

    <div class="row">
        <!-- 연결 섹션 -->
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading"><h3 class="panel-title">🔌 연결</h3></div>
                <div class="panel-body">
                    <form class="form-inline">
                        <div class="form-group">
                            <label>닉네임:</label>
                            <input type="text" id="name" class="form-control"
                                   value="${username}" readonly style="margin: 0 10px;"/>
                        </div>
                        <button id="connect" class="btn btn-success" type="button">🔗 연결</button>
                        <button id="disconnect" class="btn btn-danger" type="button"
                                disabled style="margin-left:5px;">❌ 끊기</button>
                    </form>
                    <div id="connection-status" class="connection-status">🔴 연결 해제</div>
                </div>
            </div>
        </div>

        <!-- 메시지 전송 섹션 -->
        <div class="col-md-6">
            <div class="panel panel-info">
                <div class="panel-heading"><h3 class="panel-title">💬 메시지 전송</h3></div>
                <div class="panel-body">
                    <form class="form-inline">
                        <div class="form-group" style="width:100%;">
                            <input type="text" id="content" class="form-control"
                                   placeholder="메시지를 입력하세요... (Enter키로 전송)"
                                   style="width:70%; margin-right:10px;" disabled/>
                            <button id="send" class="btn btn-primary" type="button" disabled>📤 Send</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- 채팅 메시지 표시 -->
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">📋 채팅 메시지 <small class="text-muted">실시간으로 업데이트됩니다</small></h3>
                </div>
                <div class="panel-body" style="padding:0;">
                    <div class="table-responsive chat-container">
                        <table class="table table-striped table-hover">
                            <thead><tr><th>💬 채팅 메시지</th></tr></thead>
                            <tbody id="chat-messages">
                                <tr class="info-message">
                                    <td class="text-muted text-center">🎯 연결 버튼을 클릭하여 채팅을 시작하세요.</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    // 서버에서 전달받은 방 정보
    const roomId   = '${room.roomId}';
    const roomName = '${room.roomName}';

    // ── StompJs.Client 생성 (수업과 동일한 방식) ─────────────────────────
    const wsProtocol = window.location.protocol === 'https:' ? 'wss:' : 'ws:';
    const webSocketURL = wsProtocol + '//' + window.location.host + '/chat-app';

    const stompClient = new StompJs.Client({
        brokerURL: webSocketURL
    });

    stompClient.onWebSocketError = (error) => {
        console.error('WebSocket 오류:', error);
        setConnected(false);
    };

    stompClient.onStompError = (frame) => {
        console.error('STOMP 오류:', frame.headers['message']);
    };

    // ── 연결 성공 시: 이 방 전용 토픽 구독 ──────────────────────────────
    stompClient.onConnect = (frame) => {
        console.log('연결 성공:', frame);
        setConnected(true);

        // 입장 알림 구독 (/topic/greetings/{roomId})
        stompClient.subscribe('/topic/greetings/' + roomId, (greeting) => {
            const message = JSON.parse(greeting.body);
            showMessage(message.name + '님이 입장했습니다.', 'info');
        });

        // 채팅 메시지 구독 (/topic/chat/{roomId})
        stompClient.subscribe('/topic/chat/' + roomId, (chat) => {
            const message = JSON.parse(chat.body);
            showMessage(message.name + ': ' + message.content, 'chat');
        });

        // 입장 메시지 전송
        const name = document.getElementById('name').value;
        stompClient.publish({
            destination: '/app/hello/' + roomId,
            body: JSON.stringify({ name: name })
        });
    };

    // ── 연결 ──────────────────────────────────────────────────────────────
    function connect() {
        stompClient.activate();
    }

    // ── 연결 해제 ─────────────────────────────────────────────────────────
    function disconnect() {
        stompClient.deactivate();
        setConnected(false);
    }

    // ── 메시지 전송 ───────────────────────────────────────────────────────
    function sendMessage() {
        const name = document.getElementById('name').value;
        const contentInput = document.getElementById('content');
        const content = contentInput.value.trim();

        if (!content) { contentInput.focus(); return; }

        stompClient.publish({
            destination: '/app/chat/' + roomId,
            body: JSON.stringify({ name: name, content: content })
        });

        contentInput.value = '';
        contentInput.focus();
    }

    // ── UI 상태 관리 ──────────────────────────────────────────────────────
    function setConnected(connected) {
        document.getElementById('connect').disabled    = connected;
        document.getElementById('disconnect').disabled = !connected;
        document.getElementById('send').disabled       = !connected;
        document.getElementById('content').disabled    = !connected;

        const status = document.getElementById('connection-status');
        status.textContent  = connected ? '🟢 연결됨' : '🔴 연결 해제';
        status.className    = 'connection-status ' + (connected ? 'text-success' : 'text-danger');
    }

    // ── 메시지 화면 출력 ──────────────────────────────────────────────────
    function showMessage(message, messageType = 'chat') {
        const container = document.getElementById('chat-messages');
        const now = new Date();
        const time = now.toLocaleTimeString('ko-KR', { hour:'2-digit', minute:'2-digit', second:'2-digit' });

        let rowClass = '';
        if (messageType === 'info')  rowClass = 'class="info-message text-muted"';
        else if (messageType === 'error') rowClass = 'class="error-message text-danger"';
        else rowClass = 'class="chat-message"';

        const div = document.createElement('div');
        div.textContent = message;

        container.innerHTML += `
            <tr ${rowClass}>
                <td><span class="message-time text-muted">[\${time}]</span>\${div.innerHTML}</td>
            </tr>`;

        const tableContainer = container.closest('.table-responsive');
        if (tableContainer) tableContainer.scrollTop = tableContainer.scrollHeight;
    }

    // ── 이벤트 등록 ───────────────────────────────────────────────────────
    window.addEventListener('DOMContentLoaded', () => {
        document.getElementById('connect').addEventListener('click', (e) => { e.preventDefault(); connect(); });
        document.getElementById('disconnect').addEventListener('click', (e) => { e.preventDefault(); disconnect(); });
        document.getElementById('send').addEventListener('click', (e) => { e.preventDefault(); sendMessage(); });
        document.getElementById('content').addEventListener('keypress', (e) => {
            if (e.key === 'Enter') { e.preventDefault(); sendMessage(); }
        });
        setConnected(false);
    });

    window.addEventListener('beforeunload', () => {
        if (stompClient && stompClient.connected) stompClient.deactivate();
    });
</script>
</body>
</html>
