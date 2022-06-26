package dawnteam.dawnplanner.dashboard.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Cards {

    @Id // PrimaryKey
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // 자동생성시 시퀀스 할당
    private Long id; /* 게시물 ID */

    @Column(name = "card_id", nullable = false, unique = true)
    private Long cardId;

    @Column(nullable = false)
    private String cardTitle;

    @Column(columnDefinition = "TEXT")
    private String cardDescription;

    @Column(nullable = false)
    private Character cardStatus; /* 게시물 상태값 0:toDo, 1:doing, 2:done */

    @ManyToOne
    @JoinColumn(name = "board_id", referencedColumnName = "board_id")
    private Boards board; // Boards 객체

    public Cards(Long cardId, String cardTitle, String cardDescription, Character cardStatus) {
        this.cardId = cardId;
        this.cardTitle = cardTitle;
        this.cardDescription = cardDescription;
        this.cardStatus = cardStatus;
    }
}
