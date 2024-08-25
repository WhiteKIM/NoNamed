package hwagae.Nonamed.user.service.impl;

import hwagae.Nonamed.user.dto.request.LoginUserDto;
import hwagae.Nonamed.user.dto.request.RegisterUserDto;
import hwagae.Nonamed.user.model.User;
import hwagae.Nonamed.user.repository.UserRepository;
import hwagae.Nonamed.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    @Override
    public void register(RegisterUserDto registerInfo) {
        String rawPassword = registerInfo.getPassword();
        registerInfo.setPassword(encoder.encode(rawPassword));

        userRepository.save(registerInfo.toEntity());
    }

    @Override
    public User login(LoginUserDto loginUserDto) {
        Optional<User> optionalUser = userRepository.findByUsername(loginUserDto.getUsername());

        if(optionalUser.isEmpty())
            throw new RuntimeException(); // @TODO 예외는 나중에 잘 변경

        User user = optionalUser.get();
        if(!encoder.matches(loginUserDto.getPassword(), user.getPassword())) {
            throw new RuntimeException();
        }

        return user;
    }
}
