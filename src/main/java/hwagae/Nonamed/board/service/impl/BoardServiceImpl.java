package hwagae.Nonamed.board.service.impl;

import hwagae.Nonamed.board.dto.request.UpdateBoardDto;
import hwagae.Nonamed.board.dto.request.WriteBoardDto;
import hwagae.Nonamed.board.model.Board;
import hwagae.Nonamed.board.repository.BoardRepository;
import hwagae.Nonamed.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 게시글 관련 서비스 구현체
 * 필요한 기능은 먼저 추상체에 선언후 구현하여 사용해주세요.
 * @author WhiteKIM
 * @Date 2024.08.05
 */
@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    /**
     * 새로운 게시글을 작성한다.
     * @param writeBoard - 작성할 게시글 정보
     */
    @Override
    public void writeBoard(WriteBoardDto writeBoard) {
        boardRepository.save(writeBoard.toEntity());
    }


    /**
     * 작성된 게시글 정보를 입력한 정보로 수정
     * @param updateBoard - 수정 정보
     */
    @Override
    public void updateBoard(UpdateBoardDto updateBoard) {
        Optional<Board> optionalBoard = boardRepository.findById(updateBoard.getId());
        if(optionalBoard.isEmpty())
            throw new RuntimeException();//@TODO 적당한 예외로 변경

        Board targetBoard = optionalBoard.get();
        targetBoard.updateBoard(updateBoard);
    }

    /**
     * 게시글 삭제 기능
     * @param id - 삭제할 대상 아이디
     */
    @Override
    public void deleteBoard(String id) {
        boardRepository.deleteById(id);
    }
}
