package site.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.interfaces.user.RegistrationInterface;

@Component
public class RegistrationSteps {

    @Autowired
    private RegistrationInterface registrationInterface;

    public void createUser(String email, String password) {
        registrationInterface.createUser(email, password);
    }
}
