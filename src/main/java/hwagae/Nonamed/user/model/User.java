package hwagae.Nonamed.user.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;//PK
    private String username;//사용자 아이디
    private String password;//사용자 패스워드
    private String email;//사용자 비밀번호
    private String nickname;//사용자 별칭
    private String name;//사용자 실명
    private String phoneNumber;//사용자 전화번호
    private Boolean isIdentify;//사용자 인증여부

    public User(String username, String password, String email, String nickname, String name, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
