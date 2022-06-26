package dawnteam.dawnplanner.dashboard.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Boards { // implements Serializable
    @Id // PrimaryKey
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // 자동생성시 시퀀스 할당
    private Long id; /* 게시물 ID */

    @Column(name = "board_id", nullable = false, unique = true)
    private Long boardId;

    @Column(length = 400, nullable = false)
    private String boardTitle; /* 게시물 제목 */

    @Column(length = 100)
    private String boardAlias; /* 게시물 별칭 */

    @Column(columnDefinition = "TEXT")
    private String boardDescription; /* 게시물 내용 */

    private String author; /* 작성자 (user_id) */

    private Date boardCreated; // 보드 생성일

    private Date boardExpired; // 보드 만료일

    public Boards(Long boardId, String boardTitle, String boardAlias, String boardDescription,
                  String author, Date boardCreated, Date boardExpired) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.boardAlias = boardAlias;
        this.boardDescription = boardDescription;
        this.author = author;
        this.boardCreated = boardCreated;
        this.boardExpired = boardExpired;
    }
}
