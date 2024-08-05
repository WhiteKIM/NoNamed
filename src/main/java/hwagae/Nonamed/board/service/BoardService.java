package hwagae.Nonamed.board.service;

import hwagae.Nonamed.board.dto.request.UpdateBoardDto;
import hwagae.Nonamed.board.dto.request.WriteBoardDto;

/**
 * 게시글 관련 서비스 인터페이스
 * 게시글 관련 비즈니스 기능이 필요한 경우, 해당 인터페이스에 선언후 구현
 * @author WhiteKIM
 * @Date 2024.08.05
 */
public interface BoardService {
    void writeBoard(WriteBoardDto writeBoard);
    void updateBoard(UpdateBoardDto updateBoard);
    void deleteBoard(String id);
}
