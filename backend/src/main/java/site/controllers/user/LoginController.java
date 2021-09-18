package site.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import site.Login;

@Controller
public class LoginController {

    @GetMapping("/site.login")
    public String loginForm(Model model) {
        model.addAttribute("site.login", new Login());
        return "site.login";
    }

    @PostMapping("/site.login")
    public String loginSubmit(@ModelAttribute Login login, Model model) {
        model.addAttribute("site.login", login);
        return "site.login";
    }
}
