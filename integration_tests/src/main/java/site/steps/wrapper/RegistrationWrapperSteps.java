package site.steps.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.steps.raw.RegistrationRawSteps;

@Component
public class RegistrationWrapperSteps extends BaseWrapperSteps {

    @Autowired
    private RegistrationRawSteps registrationSteps;

    public void createUser(String email, String password) {
        execute(() -> registrationSteps.createUser(email, password));
    }

    public void restorePassword(String email, String password) {
        execute(() -> registrationSteps.restorePassword(email, password));
    }
}
