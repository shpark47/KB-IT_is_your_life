package org.scoula.chat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.chat.dto.ChatRoom;
import org.scoula.chat.service.ChatRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
@Log4j2
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    // 전체 대화방 목록 페이지
    @GetMapping("/rooms")
    public String rooms(Model model) {
        log.info("대화방 목록 조회");
        List<ChatRoom> rooms = chatRoomService.findAllRooms();
        model.addAttribute("rooms", rooms);
        return "chat/rooms";  // /WEB-INF/views/chat/rooms.jsp
    }

    // 대화방 개설 (POST 처리 후 목록으로 리다이렉트)
    @PostMapping("/rooms")
    public String createRoom(@RequestParam String roomName) {
        log.info("대화방 개설: {}", roomName);
        chatRoomService.createRoom(roomName);
        return "redirect:/chat/rooms";  // 방 생성 후 목록으로 이동
    }

    // 특정 대화방 입장 페이지
    @GetMapping("/rooms/{roomId}")
    public String enterRoom(@PathVariable String roomId,
                            @RequestParam String username,
                            Model model) {
        log.info("대화방 입장 - roomId: {}, username: {}", roomId, username);
        ChatRoom room = chatRoomService.findRoomById(roomId);
        if (room == null) {
            return "redirect:/chat/rooms";
        }
        model.addAttribute("room", room);
        model.addAttribute("username", username);
        return "chat/room";  // /WEB-INF/views/chat/room.jsp
    }
}
