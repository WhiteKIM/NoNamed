package hwagae.Nonamed.chat.repository;

import hwagae.Nonamed.chat.model.ChatRoom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChatRoomRepository {

    private List<ChatRoom> chatRoomList = new ArrayList<>();

    public List<ChatRoom> findAll() {
        return chatRoomList;
    }
}
