package hwagae.Nonamed.user.service.impl;

import hwagae.Nonamed.user.dto.request.RegisterUserDto;
import hwagae.Nonamed.user.model.User;
import hwagae.Nonamed.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class UserServiceImplTest {
    @Autowired
    UserRepository userRepository;

    /**
     * 회원가입 성공여부
     */
    @Test
    void registerUser() {
        RegisterUserDto registerUserDto = new RegisterUserDto("test", "1234", "tester", null, null, null);
        userRepository.save(registerUserDto.toEntity());
        List<User> userList = userRepository.findAll();

        Assertions.assertThat(userList.get(0).getNickname()).isEqualTo("tester");
    }
}