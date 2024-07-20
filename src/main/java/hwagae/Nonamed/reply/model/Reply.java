package hwagae.Nonamed.reply.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

/**
 * @date : 2024.07.20
 * @author WhiteKIm
 * @comment
 * 댓글 엔티티 모델
 */
@Entity
@Getter
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;//PK
    private String content;//댓글 내용
}
