package hwagae.Nonamed.chat.service;

import hwagae.Nonamed.chat.model.ChatRoom;

import java.util.List;

public interface ChatRoomService {
    List<ChatRoom> findAll();

    ChatRoom findById(String roomId);

    ChatRoom createRoom(String title);
}
