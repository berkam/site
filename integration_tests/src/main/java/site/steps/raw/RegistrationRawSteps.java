package site.steps.raw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import site.interfaces.user.RegistrationInterface;

@Component
public class RegistrationRawSteps extends BaseRawSteps {

    @Autowired
    private RegistrationInterface registrationInterface;

    public ResponseEntity<?> createUser(String email, String password) {
        return execute(() -> registrationInterface.createUser(email, password));
    }

    public ResponseEntity<?> restorePassword(String email, String password) {
        return execute(() -> registrationInterface.restorePassword(email, password));
    }
}
