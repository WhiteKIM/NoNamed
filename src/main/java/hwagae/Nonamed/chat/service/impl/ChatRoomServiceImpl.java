package hwagae.Nonamed.chat.service.impl;

import hwagae.Nonamed.chat.model.ChatRoom;
import hwagae.Nonamed.chat.repository.ChatRoomRepository;
import hwagae.Nonamed.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    @Override
    public List<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }
}
