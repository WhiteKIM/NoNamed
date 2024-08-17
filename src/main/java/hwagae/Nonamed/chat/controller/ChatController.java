package hwagae.Nonamed.chat.controller;

import hwagae.Nonamed.chat.model.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final SimpMessageSendingOperations messageSendingOperations;

    @MessageMapping("/chat/message")
    public void message(Chat chat) {
        messageSendingOperations.convertAndSend("/sub/chat/room/" + chat.getRoomId(), chat);
    }
}
