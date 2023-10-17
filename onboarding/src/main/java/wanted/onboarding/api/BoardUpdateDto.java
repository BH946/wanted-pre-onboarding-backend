package wanted.onboarding.api;

import lombok.Getter;

@Getter
public class BoardUpdateDto {
    private String position; // 채용포지션
    private Long reward; // 채용보상금
    private String content; // 채용내용
    private String skill; // 사용기술
    public BoardUpdateDto(String p, Long r, String c, String s) {
        position=p; reward=r; content=c; skill=s;
    }
}
