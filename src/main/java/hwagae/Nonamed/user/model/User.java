package hwagae.Nonamed.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
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
}
