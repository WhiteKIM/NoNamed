package hwagae.Nonamed.chat.model;

import lombok.Data;

@Data
public class Chat {
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
}
