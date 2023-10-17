package wanted.onboarding.api;

import lombok.Getter;
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

    /**
     * 공고 검색 조회
     */
    @GetMapping("/search/{search}")
    public ResponseEntity<List<Board>> findSearchBoards(@PathVariable String search) {
        List<Board> boards = boardService.findSearchAll(search);
        return ResponseEntity.status(HttpStatus.OK).body(boards);
    }
    /**
     * 채용 상세 페이지 조회
     */
    @GetMapping("/{boardId}")
    public ResponseEntity<BoardDtoRes> findSearchBoards(@PathVariable Long boardId) {
        Board board = boardService.findOne(boardId);
        List<Long> idList = boardService.findIdList();
        BoardDtoRes result = new BoardDtoRes(board, idList);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Getter
    static class BoardDtoRes {
        private Long id; // pk
        private String position; // 채용포지션
        private Long reward; // 채용보상금
        private String content; // 채용내용
        private String skill; // 사용기술
        private List<Long> idList; // 회사가올린다른채용공고
        public BoardDtoRes(Board board, List<Long> idList) {
            id = board.getId();
            position = board.getPosition();
            reward = board.getReward();
            content = board.getContent();
            skill = board.getSkill();
            this.idList = idList;
        }
    }
}
