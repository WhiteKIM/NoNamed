package hwagae.Nonamed.team.dto.request;

import hwagae.Nonamed.team.model.Team;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 팀생성 DTO
 * @Comment
 * 팀명은 Null이 허용되지 않습니다.
 */
@Data
public class CreateTeamDto {
    @NotNull
    private String teamName;

    // 검증 X
    private String purpose;
    private String description;

    public Team toEntity() {
        return new Team(teamName, purpose, description);
    }
}
