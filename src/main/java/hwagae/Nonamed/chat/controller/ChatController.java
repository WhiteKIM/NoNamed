package hwagae.Nonamed.chat.controller;

import hwagae.Nonamed.chat.model.Chat;
import hwagae.Nonamed.chat.model.ChatRoom;
import hwagae.Nonamed.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
@Slf4j
public class ChatController {

    private final SimpMessageSendingOperations messageSendingOperations;
    private final ChatRoomService chatRoomService;

    @MessageMapping("/chat/message")
    public void message(Chat chat) {
        log.info("Chat Receiving {}", chat); // Transmission

        ChatRoom chatRoom = chatRoomService.findById(chat.getRoomId());
        chatRoom.chatting(chat); //모든 채팅은 채팅방에 안에서 기록한다.
        messageSendingOperations.convertAndSend("/sub/chat/room/" + chat.getRoomId(), chat);
    }
}
