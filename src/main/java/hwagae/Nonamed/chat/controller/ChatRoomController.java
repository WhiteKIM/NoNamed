package hwagae.Nonamed.chat.controller;

import hwagae.Nonamed.chat.model.ChatRoom;
import hwagae.Nonamed.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/chat/room/{roomId}")
    public ChatRoom chatting(@PathVariable String roomId) {
        return chatRoomService.findById(roomId);
    }

    @PostMapping("/chat/room/create")
    public ChatRoom createRoom(String title) {
        return chatRoomService.createRoom(title);
    }
}
