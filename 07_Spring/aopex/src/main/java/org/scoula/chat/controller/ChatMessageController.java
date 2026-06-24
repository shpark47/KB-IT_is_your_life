package org.scoula.chat.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.chat.dto.ChatMessage;
import org.scoula.chat.dto.GreetingMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Log4j2
public class ChatMessageController {

    // /app/hello/{roomId} → /topic/greetings/{roomId} 구독자에게 브로드캐스트
    @MessageMapping("/hello/{roomId}")
    @SendTo("/topic/greetings/{roomId}")
    public GreetingMessage greeting(@DestinationVariable String roomId,
                                    GreetingMessage message) throws Exception {
        log.info("입장 - roomId: {}, name: {}", roomId, message.getName());
        return message;
    }

    // /app/chat/{roomId} → /topic/chat/{roomId} 구독자에게 브로드캐스트
    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/chat/{roomId}")
    public ChatMessage chat(@DestinationVariable String roomId,
                            ChatMessage message) throws Exception {
        log.info("채팅 - roomId: {}, name: {}, content: {}", roomId, message.getName(), message.getContent());
        return message;
    }
}
