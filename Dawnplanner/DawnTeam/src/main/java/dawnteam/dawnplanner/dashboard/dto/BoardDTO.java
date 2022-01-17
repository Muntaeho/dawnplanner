package dawnteam.dawnplanner.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class BoardDTO {
    private String boardTitle;
    private String boardAlias;
    private String boardDescription;
    private String author;
    private Date boardCreated;
    private Date boardExpired;
}
