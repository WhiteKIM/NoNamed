package hwagae.Nonamed.user.service;

import hwagae.Nonamed.user.dto.request.RegisterUserDto;

public interface UserService {

    // 회원가입
    void register(RegisterUserDto registerInfo);
}
