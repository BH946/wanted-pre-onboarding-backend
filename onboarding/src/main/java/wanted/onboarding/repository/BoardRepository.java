package wanted.onboarding.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import wanted.onboarding.domain.Board;

import java.util.List;

@Repository
@RequiredArgsConstructor // 생성자 주입
public class BoardRepository {
    private final EntityManager em;

    /**
     * save, findOne, findAll, remove
     */
    public void save(Board board) {
        if(board.getId() == null) {
            em.persist(board);
        }
    }
    public Board findOne(Long id) {
        return em.find(Board.class, id);
    }
    public List<Board> findAll() {
        return em.createQuery("select b from Board b", Board.class)
                .getResultList();
    }
    public void remove(Board board) {em.remove(board);}
}
