package hwagae.Nonamed.chat.controller;

import hwagae.Nonamed.chat.model.ChatRoom;
import hwagae.Nonamed.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @GetMapping("/room/list")
    public List<ChatRoom> chatRoomList() {
        return chatRoomService.findAll();
    }
}
