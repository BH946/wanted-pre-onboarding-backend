package wanted.onboarding.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import wanted.onboarding.api.BoardUpdateDto;
import wanted.onboarding.domain.Board;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Test
    public void 등록() throws Exception {
        // given
        Board board = Board.createBoard("백엔드 주니어 개발자",1000000l,"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..","Python");
        // when
        boardService.join(board);
        Board findBoard = boardService.findOne(board.getId());
        // then
        Assertions.assertEquals(board.getId(), findBoard.getId());
        log.debug("board reward : {}, findBoard reward : {}", board.getReward(), findBoard.getReward());
    }

    @Test
    public void 수정() throws Exception {
        // given
        Board board = Board.createBoard("백엔드 주니어 개발자",1000000l,"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..","Python");
        boardService.join(board);
        Board findBoard = boardService.findOne(board.getId());
        // when
        BoardUpdateDto dto = new BoardUpdateDto("백엔드 주니어 개발자", 1500000l,"원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..", "Python");
        log.debug("findBoard.id : {}, findBoard.reward : {}", findBoard.getId(), findBoard.getReward());
        Long prevData = findBoard.getReward();
        boardService.update(board, dto);
        log.debug("findBoard : {}", findBoard.getReward());
        // then
        Assertions.assertEquals(findBoard.getReward(), prevData);
    }
    @Test
    public void 삭제() throws Exception {
        // given
        Board board = Board.createBoard("백엔드 주니어 개발자",1000000l,"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..","Python");
        boardService.join(board);
        Board findBoard = boardService.findOne(board.getId());
//        Board findBoard = boardService.findOne(1l); // 1l : 등록()에서 생성한 id
        // when
        boardService.remove(findBoard);
        // then
        findBoard = boardService.findOne(1l);
        Assertions.assertEquals(findBoard, null);
    }
    @Test
    public void 조회() throws Exception {
        // given
        Board board = Board.createBoard("백엔드 주니어 개발자",1000000l,"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..","Python");
        boardService.join(board);
        Board board2 = Board.createBoard("백엔드 주니어 개발자",1000000l,"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..","Python");
        boardService.join(board2);
        // when
        List<Board> boards = boardService.findAll();
        // then
        for(Board b : boards) {
            log.debug("{}, {}, {}, {}",b.getId(),b.getReward(),b.getContent(),b.getSkill());
        }
    }
}