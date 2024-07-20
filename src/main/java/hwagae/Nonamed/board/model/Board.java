package hwagae.Nonamed.board.model;

import hwagae.Nonamed.member.model.Member;
import hwagae.Nonamed.reply.model.Reply;
import hwagae.Nonamed.team.model.Team;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToMany
    @JoinColumn(name = "reply_id")
    private List<Reply> replyList;
}
