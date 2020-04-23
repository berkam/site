import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String greetingForm(Model model) {
        model.addAttribute("login", new Greeting());
        return "login";
    }

    @PostMapping("/login")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("login", greeting);
        return "login";
    }
}
