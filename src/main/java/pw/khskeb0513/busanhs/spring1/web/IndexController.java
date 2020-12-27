package pw.khskeb0513.busanhs.spring1.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pw.khskeb0513.busanhs.spring1.config.auth.LoginUser;
import pw.khskeb0513.busanhs.spring1.config.auth.dto.SessionUser;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final HttpSession httpSession;

    @GetMapping("/")
    public String Index(Model model, @LoginUser SessionUser sessionUser) {
        if (sessionUser != null) {
            model.addAttribute("name", sessionUser.getName());
        }
        return "index";
    }

    @GetMapping("/user")
    public String returnUser(Model model, @LoginUser SessionUser sessionUser) {
        if (sessionUser != null) {
            model.addAttribute("name", sessionUser.getName());
            model.addAttribute("email", sessionUser.getEmail());
        }
        model.addAttribute("subtitle", "User Settings");
        return "user/index";
    }
}
