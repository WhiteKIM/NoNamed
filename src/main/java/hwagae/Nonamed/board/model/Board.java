package hwagae.Nonamed.board.model;

import hwagae.Nonamed.board.dto.request.UpdateBoardDto;
import hwagae.Nonamed.member.model.Member;
import hwagae.Nonamed.reply.model.Reply;
import hwagae.Nonamed.team.model.Team;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 게시글 엔티티 정보
 * 각 프로퍼터는 주석 참조
 * @author WhiteKIM
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id; //게시글 PK
    private String title; //게시글 제목
    private String content; //게시글 내용

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team; //게시글잊 작성된 팀
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member; //게시글 작성 팀원
    @OneToMany
    @JoinColumn(name = "reply_id")
    @Builder.Default
    private List<Reply> replyList = new ArrayList<>(); //게시글에 작성된 댓글 목록

    /**
     * 게시글 엔티티 수정 로직
     * 수정 정보를 받아 해당 정보로 업데이트
     * @param updateBoard - 게시글 수정 정보
     */
    public void updateBoard(UpdateBoardDto updateBoard) {
        this.title = updateBoard.getTitle();
        this.content = updateBoard.getContent();
    }

    /**
     * 댓글 연관관계 설정 로직
     * 작성한 댓글을 게시글에 포함하도록 함
     * @param reply - 작성된 댓글
     */
    public void registerReply(Reply reply) {
        this.replyList.add(reply);
    }
}
