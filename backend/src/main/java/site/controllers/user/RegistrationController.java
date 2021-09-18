package site.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import site.interfaces.user.RegistrationInterface;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationInterface registrationInterface;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(String email, String password) {
        return registrationInterface.createUser(email, password);
    }

    @PostMapping("/restorePassword")
    public ResponseEntity<?> restorePassword(String email, String password) {
        return registrationInterface.restorePassword(email, password);
    }
}
