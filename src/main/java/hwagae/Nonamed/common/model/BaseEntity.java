package hwagae.Nonamed.common.model;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * @date : 2024.07.20
 * @author WhiteKIM 
 * @comment
 * 공통 기본 엔티티 정보
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class BaseEntity {
    @CreatedDate
    private LocalDateTime atCreatedTime;//생성 시점
    @LastModifiedDate
    private LocalDateTime atUpdatedTime;//수점 시점
    private LocalDateTime atDeletedTime;//삭제 시점
}
