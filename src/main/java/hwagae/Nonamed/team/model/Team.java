package hwagae.Nonamed.team.model;

import hwagae.Nonamed.member.model.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date : 2024.07.30
 * @author WhiteKIM
 * @comment
 * Team 정보 엔티티
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//PK
    private String teamName;//팀명
    private String purpose;//팀 목적
    private String description;//팀 설명

    public Team(String teamName, String purpose, String description) {
        this.teamName = teamName;
        this.purpose = purpose;
        this.description = description;
    }

    @OneToMany
    @Builder.Default
    @JoinColumn(name = "member_id")
    private List<Member> teamMemberList = new ArrayList<>();//해당팀 소속 멤버 리스트

    public void registerMember(Member member) {
        this.teamMemberList.add(member);
    }
}
