package hwagae.Nonamed.user.service.impl;

import hwagae.Nonamed.user.dto.request.RegisterUserDto;
import hwagae.Nonamed.user.repository.UserRepository;
import hwagae.Nonamed.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public void register(RegisterUserDto registerInfo) {
        userRepository.save(registerInfo.toEntity());
    }
}
