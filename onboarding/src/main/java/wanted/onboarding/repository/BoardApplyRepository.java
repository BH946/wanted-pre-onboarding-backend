package wanted.onboarding.repository;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import wanted.onboarding.domain.Board;
import wanted.onboarding.domain.BoardApply;

import java.util.List;

@Repository
@RequiredArgsConstructor // 생성자 주입
public class BoardApplyRepository {
    private final EntityManager em;

    public void save(BoardApply boardApply) {
        if(boardApply.getId() == null) {
            em.persist(boardApply);
        }
    }
    public List<BoardApply> findUserOne(Long userId) {
        return em.createQuery("select b from BoardApply b " +
                        "where b.userId = :userId", BoardApply.class)
                .setParameter("userId", userId)
                .getResultList();
    }

}
