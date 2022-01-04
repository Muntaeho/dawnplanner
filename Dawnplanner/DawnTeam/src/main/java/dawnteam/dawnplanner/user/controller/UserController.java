package dawnteam.dawnplanner.user.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import dawnteam.dawnplanner.user.dto.UserInfoDTO;
import dawnteam.dawnplanner.user.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    @GetMapping("/signup")
    public String Signup(){
        return "/signup";
    }
    @PostMapping("/signup")
    public String signup(UserInfoDTO infoDto) { // 회원 추가
        userService.save(infoDto);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}
