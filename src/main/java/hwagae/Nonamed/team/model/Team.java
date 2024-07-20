package hwagae.Nonamed.team.model;

import hwagae.Nonamed.member.model.Member;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

/**
 * @Date : 2024.07.30
 * @author WhiteKIM
 * @comment
 * Team 정보 엔티티
 */
@Entity
@Getter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//PK
    private String teamName;//팀명
    private String purpose;//팀 목적
    private String description;//팀 설명

    @OneToMany
    @JoinColumn(name = "member_id")
    private List<Member> teamMemberList;//해당팀 소속 멤버 리스트
}
