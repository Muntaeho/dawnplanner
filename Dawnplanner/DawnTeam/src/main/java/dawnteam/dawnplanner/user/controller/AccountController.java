package dawnteam.dawnplanner.user.controller;

import dawnteam.dawnplanner.user.dto.UserDTO;
import dawnteam.dawnplanner.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class AccountController {

    private UserService userService;

    @GetMapping("/user/update")
    public String update()
    {
        return "user/update";
    }
}
