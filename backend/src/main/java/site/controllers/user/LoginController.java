package site.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import site.interfaces.user.LoginInterface;

@Controller
public class LoginController {

    @Autowired
    private LoginInterface loginInterface;

    @PostMapping("/login")
    public ResponseEntity<?> createUser(String email, String password) {
        return loginInterface.login(email, password);
    }
}
