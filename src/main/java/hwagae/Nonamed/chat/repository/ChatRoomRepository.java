package hwagae.Nonamed.chat.repository;

import hwagae.Nonamed.chat.model.ChatRoom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ChatRoomRepository {

    private List<ChatRoom> chatRoomList = new ArrayList<>();

    public List<ChatRoom> findAll() {
        return chatRoomList;
    }

    public Optional<ChatRoom> findById(String roomId) {
        ChatRoom room =  null;
        for(ChatRoom chatRoom : chatRoomList) {
            if(chatRoom.getRoomId().equals(roomId)) {
                room = chatRoom;
                break;
            }
        }

        return Optional.ofNullable(room);
    }

    public ChatRoom createRoom(String title) {
        ChatRoom room = new ChatRoom(title);
        chatRoomList.add(room);

        return room;
    }
}
