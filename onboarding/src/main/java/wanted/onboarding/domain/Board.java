package wanted.onboarding.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import wanted.onboarding.api.BoardUpdateDto;

@Entity
@Getter @Setter
public class Board {
    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id; // pk
    private String position; // 채용포지션
    private Long reward; // 채용보상금
    private String content; // 채용내용
    private String skill; // 사용기술

    ///편의 메서드==//
    public Board update(BoardUpdateDto dto) {
        this.position = dto.getPosition();
        this.reward = dto.getReward();
        this.content = dto.getContent();
        this.skill = dto.getSkill();
        return this;
    }

    //==생성 편의 메서드==//
    public static Board createBoard(String position, Long reward, String content, String skill) {
        Board board = new Board();
        board.setPosition(position);
        board.setReward(reward);
        board.setContent(content);
        board.setSkill(skill);
        return board;
    }
}
