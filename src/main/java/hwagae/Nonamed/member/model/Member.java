package hwagae.Nonamed.member.model;

import hwagae.Nonamed.team.model.Team;
import hwagae.Nonamed.user.model.User;
import jakarta.persistence.*;
import lombok.*;

/**
 * User - Team이 N : M의 관계를 가지는 것을 방지하기 위해 존재
 * User - Member - Team N : 1 : N 이런식으로 구성된다.
 * @author WhiteKIM
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
