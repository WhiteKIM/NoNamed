package hwagae.Nonamed.chat.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ChatRoom {
    private String roomId; // 방 아이디, UUID로 설정
    private String roomTitle;// 방제목
    private List<Chat> chatList = new ArrayList<>();

    public ChatRoom(String roomTitle) {
        this.roomId = UUID.randomUUID().toString();
        this.roomTitle = roomTitle;
    }

    public void chatting(Chat chat) {
        chatList.add(chat);
        chat.setRoomId(this.roomId);
    }
}
