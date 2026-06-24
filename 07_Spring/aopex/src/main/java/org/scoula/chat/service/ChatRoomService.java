package org.scoula.chat.service;

import org.scoula.chat.dto.ChatRoom;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChatRoomService {

    // 대화방 목록을 메모리에 저장 (roomId -> ChatRoom)
    private Map<String, ChatRoom> chatRoomMap = new LinkedHashMap<>();

    // 전체 대화방 목록 조회 (생성 순서 유지)
    public List<ChatRoom> findAllRooms() {
        return new ArrayList<>(chatRoomMap.values());
    }

    // 특정 대화방 조회 (roomId로 검색)
    public ChatRoom findRoomById(String roomId) {
        return chatRoomMap.get(roomId);
    }

    // 새 대화방 생성
    public ChatRoom createRoom(String roomName) {
        ChatRoom chatRoom = ChatRoom.create(roomName);
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }
}
