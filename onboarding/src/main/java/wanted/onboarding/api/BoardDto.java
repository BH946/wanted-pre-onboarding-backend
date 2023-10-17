package wanted.onboarding.api;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 파라미터없는 기본생성자를 제공
public class BoardDto {
    private String position; // 채용포지션
    private Long reward; // 채용보상금
    private String content; // 채용내용
    private String skill; // 사용기술
    public BoardDto(String position, Long reward, String content, String skill) {
        this.position=position;
        this.reward=reward;
        this.content=content;
        this.skill=skill;
    }
}
