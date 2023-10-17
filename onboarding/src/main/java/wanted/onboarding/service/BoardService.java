package wanted.onboarding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanted.onboarding.api.BoardDto;
import wanted.onboarding.domain.Board;
import wanted.onboarding.repository.BoardRepository;

import java.util.List;

@Service
@Transactional(readOnly = true) // 읽기모드
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    /**
     * save
     */
    @Transactional // 쓰기모드
    public void join(Board board) { boardRepository.save(board);}
    /**
     * findOne, findAll
     */
    public Board findOne(Long boardId) { return boardRepository.findOne(boardId);}
    public List<Board> findAll() { return boardRepository.findAll();}
    /**
     * update
     */
    @Transactional // 쓰기모드
    public Board update(Board board, BoardDto dto) {
        board.update(dto); // dirty checking
        return board;
    }
    /**
     * remove
     */
    @Transactional // 쓰기모드
    public void remove(Board board) {
        boardRepository.remove(board);
    }

    /**
     * findSearchAll
     */
    public List<Board> findSearchAll(String search) {
        return boardRepository.findSearchAll(search);
    }
}
