package hwagae.Nonamed.user.dto.request;

import hwagae.Nonamed.user.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 회원가입 DTO
 * @Comment
 * username, password, nickname은 null 허용 X
 * password는 추후 길이 및 포함 문자 추가
 */
@Data
public class RegisterUserDto {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String nickname;

    // 현재는 검증하지 않는 항목들
    private String email;
    private String name;
    private String phoneNumber;


    public RegisterUserDto(String username, String password, String nickname, String email, String name, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public User toEntity() {
        return new User(username, password, email, nickname, name, phoneNumber);
    }
}
