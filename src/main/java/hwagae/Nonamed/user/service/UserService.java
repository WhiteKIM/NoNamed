package hwagae.Nonamed.user.service;

import hwagae.Nonamed.user.dto.request.LoginUserDto;
import hwagae.Nonamed.user.dto.request.RegisterUserDto;
import hwagae.Nonamed.user.model.User;

public interface UserService {

    // 회원가입
    void register(RegisterUserDto registerInfo);
    // 로그인
    User login(LoginUserDto loginUserDto);
}
