package pw.khskeb0513.busanhs.spring1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;
import pw.khskeb0513.busanhs.spring1.config.auth.LoginUser;
import pw.khskeb0513.busanhs.spring1.config.auth.dto.SessionUser;

@Controller
public class IndexController {

    @GetMapping("/")
    public String Index(Model model, @LoginUser SessionUser sessionUser) {
        if (sessionUser != null) {
            model.addAttribute("name", sessionUser.getName())
                    .addAttribute("email", sessionUser.getEmail());
        }
        return "index";
    }

    @GetMapping("/gui")
    public RedirectView GUI() {
        return new RedirectView("/");
    }
}
