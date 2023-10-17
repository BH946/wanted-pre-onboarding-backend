package wanted.onboarding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanted.onboarding.domain.Board;
import wanted.onboarding.domain.BoardApply;
import wanted.onboarding.repository.BoardApplyRepository;

import java.util.List;

@Service
@Transactional(readOnly = true) // 읽기모드
@RequiredArgsConstructor
public class BoardApplyService {
    private final BoardApplyRepository boardApplyRepository;

    @Transactional // 쓰기모드
    public void join(BoardApply boardApply) { boardApplyRepository.save(boardApply);}

    public List<BoardApply> findUserOne(Long userId) { return boardApplyRepository.findUserOne(userId);}

}
