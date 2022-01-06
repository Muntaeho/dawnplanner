package dawnteam.dawnplanner.user.controller;

import dawnteam.dawnplanner.user.dto.UserDTO;
import dawnteam.dawnplanner.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class SignupController {

    private final UserService userService;
    @GetMapping("/signup")
    public String Signup(){
        return "signup";
    }
    @PostMapping("/signup")
    public String signup(UserDTO infoDto) { // 회원 추가
        userService.save(infoDto);
        return "redirect:/login";
    }
    @GetMapping("/")
    public String main(){
        return "main";
    }
}
