package hwagae.Nonamed.board.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateBoardDto {
    @NotNull
    private String id;
    @NotNull
    private String title;
    @NotNull
    private String content;
}
