package site.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.steps.logic.RegistrationSteps;
import site.steps.wrapper.RegistrationWrapperSteps;

import static site.utils.TestData.getRandomEmail;
import static site.utils.TestData.getRandomPassword;

@SpringBootTest
public class RegistrationTest {

    @Autowired
    RegistrationWrapperSteps registrationWrapperSteps;
    @Autowired
    RegistrationSteps registrationSteps;

    @Test
    public void createUser() {
        String email = getRandomEmail();
        String password = getRandomPassword();
        registrationWrapperSteps.createUser(email, password);
        registrationSteps.checkUserExists(email, password);
    }

    @Test
    public void restorePassword() {
        String email = getRandomEmail();
        registrationWrapperSteps.createUser(email, getRandomEmail());
        registrationWrapperSteps.restorePassword(email, getRandomEmail());
    }

    @Test
    public void restorePasswordNegative() {
        registrationWrapperSteps.restorePassword(getRandomEmail(), getRandomEmail());
    }
}
