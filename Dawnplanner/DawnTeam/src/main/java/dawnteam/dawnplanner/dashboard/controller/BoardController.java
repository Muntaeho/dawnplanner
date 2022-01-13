package dawnteam.dawnplanner.dashboard.controller;

import dawnteam.dawnplanner.dashboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController { // 보드 컨트롤러

    private BoardService boardService;

    @GetMapping(value = "/list")
    public String list(@PageableDefault Pageable pageable, Model model){
        model.addAttribute("boardList", boardService.showBoardList(pageable));
        return "/board/list";
    }

    @GetMapping({"", "/"}) // 보드 상세(카드)
    public String boardForm(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) {
        model.addAttribute("boards", boardService.findBoardsByIdx(idx));
        return "/board/form";
    }
}
