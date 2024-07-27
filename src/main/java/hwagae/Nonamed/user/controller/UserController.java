package hwagae.Nonamed.user.controller;

import hwagae.Nonamed.common.model.CommonRespEntity;
import hwagae.Nonamed.user.dto.request.RegisterUserDto;
import hwagae.Nonamed.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public CommonRespEntity<String> registerUser(RegisterUserDto registerInfo) {
        userService.register(registerInfo);

        return new CommonRespEntity<>(200, "Success", null);
    }
}
