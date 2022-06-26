package dawnteam.dawnplanner.user.controller;

import dawnteam.dawnplanner.user.dto.UserDTO;
import dawnteam.dawnplanner.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class SignupController {

    private final UserService userService;

    @GetMapping("/signup")
    public String Signup() {
        return "signup";
    }

    /* 회원가입 */
    @PostMapping("/signup")
    public String signup(@Valid UserDTO infoDto, Errors errors, Model model) {
        if (errors.hasErrors()) { // 에러 발생시
            model.addAttribute("infoDto", infoDto);
            /* 유효성 통과 못한 필드와 메시지를 핸들링 */
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
            /* 회원가입 페이지로 다시 리턴 */
            return "signup";
        }
        /* 회원가입 성공시 */
        userService.save(infoDto);
        return "redirect:/login";
    }

    @GetMapping("/")
    public String main() {
        return "main";
    }
}
