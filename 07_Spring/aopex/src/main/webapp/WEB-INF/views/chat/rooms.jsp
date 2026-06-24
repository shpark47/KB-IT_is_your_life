<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>채팅방 목록</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        body { padding: 30px; }
        .room-item {
            display: flex; justify-content: space-between; align-items: center;
            padding: 15px; margin-bottom: 10px;
            border: 1px solid #ddd; border-radius: 6px; background: #fafafa;
        }
        .room-name { font-size: 16px; font-weight: bold; }
        .no-rooms { color: #999; text-align: center; padding: 30px; }
    </style>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>💬 채팅방 목록</h1>
    </div>

    <!-- 대화방 개설 -->
    <div class="panel panel-primary">
        <div class="panel-heading"><h3 class="panel-title">+ 새 대화방 개설</h3></div>
        <div class="panel-body">
            <form action="/chat/rooms" method="post" class="form-inline">
                <div class="form-group">
                    <input type="text" name="roomName" class="form-control"
                           placeholder="대화방 이름을 입력하세요" required style="width:300px;"/>
                </div>
                <button type="submit" class="btn btn-primary" style="margin-left:10px;">개설</button>
            </form>
        </div>
    </div>

    <!-- 대화방 목록 -->
    <div class="panel panel-default">
        <div class="panel-heading"><h3 class="panel-title">대화방 목록</h3></div>
        <div class="panel-body">
            <c:choose>
                <c:when test="${empty rooms}">
                    <p class="no-rooms">아직 개설된 대화방이 없습니다. 첫 번째 방을 만들어보세요!</p>
                </c:when>
                <c:otherwise>
                    <c:forEach var="room" items="${rooms}">
                        <div class="room-item">
                            <span class="room-name">🏠 ${room.roomName}</span>
                            <form action="/chat/rooms/${room.roomId}" method="get" class="form-inline">
                                <div class="form-group">
                                    <input type="text" name="username" class="form-control"
                                           placeholder="닉네임" required style="width:120px;"/>
                                </div>
                                <button type="submit" class="btn btn-success" style="margin-left:8px;">입장</button>
                            </form>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>
