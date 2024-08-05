package hwagae.Nonamed.board.dto.request;


import hwagae.Nonamed.board.model.Board;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WriteBoardDto {
    @NotNull
    private String title;
    @NotNull
    private String content;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
