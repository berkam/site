package site.steps.raw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import site.interfaces.user.LoginInterface;

@Component
public class LoginRawSteps extends BaseRawSteps {

    @Autowired
    private LoginInterface loginInterface;

    public ResponseEntity<?> restorePassword(String email, String password) {
        return execute(() -> loginInterface.login(email, password));
    }
}
