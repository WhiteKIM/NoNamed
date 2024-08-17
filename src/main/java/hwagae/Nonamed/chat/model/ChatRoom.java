package hwagae.Nonamed.chat.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ChatRoom {
    private String roomId; // 방 아이디, UUID로 설정
    private String roomTitle;// 방제목

    public ChatRoom(String roomTitle) {
        this.roomId = UUID.randomUUID().toString();
        this.roomTitle = roomTitle;
    }
}
