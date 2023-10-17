package wanted.onboarding.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wanted.onboarding.domain.Board;
import wanted.onboarding.service.BoardService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/boards")
public class BoardApiController {
    private final BoardService boardService;

    /**
     * 공고 등록
     */
    @PostMapping("/new")
    public ResponseEntity<String> createBoard(@RequestBody BoardDto dto) {
        Board board = Board.createBoard(dto.getPosition(), dto.getReward(), dto.getContent(), dto.getSkill());
        boardService.join(board);
        return ResponseEntity.status(HttpStatus.CREATED).body("공고 등록 완료");
    }
    /**
     * 공고 수정
     */
    @PostMapping("/update/{boardId}")
    public ResponseEntity<String> updateBoard(@PathVariable Long boardId, @RequestBody BoardDto dto) {
        Board board = boardService.findOne(boardId);
        if(board == null) return null;
        boardService.update(board, dto);
        return ResponseEntity.status(HttpStatus.OK).body("공고 수정 완료");
    }
    /**
     * 공고 삭제
     */
    @PostMapping("/remove/{boardId}")
    public ResponseEntity<String> removeBoard(@PathVariable Long boardId) {
        Board board = boardService.findOne(boardId);
        if(board == null) return null;
        boardService.remove(board);
        return ResponseEntity.status(HttpStatus.OK).body("공고 삭제 완료");
    }
    /**
     * 공고 조회
     */
    @GetMapping()
    public ResponseEntity<List<Board>> findBoards() {
        List<Board> boards = boardService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(boards);
    }
}
