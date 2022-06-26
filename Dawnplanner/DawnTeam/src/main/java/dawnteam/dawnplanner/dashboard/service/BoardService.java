package dawnteam.dawnplanner.dashboard.service;

import dawnteam.dawnplanner.dashboard.domain.Boards;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    Page<Boards> showBoardList(Pageable pageable);

    Boards findBoardsByIdx(Long idx);
}
