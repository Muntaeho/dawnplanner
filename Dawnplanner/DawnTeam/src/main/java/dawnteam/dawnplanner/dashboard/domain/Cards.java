package dawnteam.dawnplanner.dashboard.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Cards {

    @Id // PrimaryKey
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // 자동생성시 시퀀스 할당
    private Long id; /* 게시물 ID */

    private String card_status; /* 게시물 상태값 0:toDo, 1:doing, 2:done */
}
