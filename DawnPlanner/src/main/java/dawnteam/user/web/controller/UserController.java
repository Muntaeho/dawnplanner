package dawnteam.user.web.controller;

import dawnteam.user.service.UserService;
import dawnteam.user.service.dvo.UserInfoDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String signup(UserInfoDto infoDto) { // 회원 추가
        userService.save(infoDto);
        return "redirect:/login";
    }

    // 추가
    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

    @GetMapping(value = "/error")
    public String error(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
        // modelmap에 error code 설정
        modelmap.addAttribute("Data", "error code : " + res.getStatus());
        // view의 파일명
        return "redirect:/error";
    }

}
