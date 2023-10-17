package wanted.onboarding.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class BoardApply {
    @Id
    @GeneratedValue
    @Column(name = "board_apply_id")
    private Long id;
    private Long boardId;
    private Long userId;
}
