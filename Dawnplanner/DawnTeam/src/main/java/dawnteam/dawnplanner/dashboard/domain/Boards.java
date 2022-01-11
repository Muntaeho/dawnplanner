package dawnteam.dawnplanner.dashboard.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Boards {
    @Id // PrimaryKey
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // 자동생성시 시퀀스 할당
    private Long id; /* 게시물 ID */

    @Column(length = 400, nullable = false)
    private String board_title; /* 게시물 제목 */

    @Column(length = 100, nullable = true)
    private String board_alias; /* 게시물 별칭 */

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description; /* 게시물 내용 */

    private String author; /* 작성자 (user_id) */

    public Boards(String board_title, String board_alias, String description, String author) {
        this.board_title = board_title;
        this.board_alias = board_alias;
        this.description = description;
        this.author = author;
    }
}
