package site.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.steps.wrapper.RegistrationWrapperSteps;
import site.utils.TestData;

@SpringBootTest
public class RegistrationTest {

    @Autowired
    RegistrationWrapperSteps registrationSteps;

    @Test
    public void createUser() {
        registrationSteps.createUser(TestData.getRandomEmail(), TestData.getRandomEmail());

    }

    @Test
    public void restorePassword() {
        String email = TestData.getRandomEmail();
        registrationSteps.createUser(email, TestData.getRandomEmail());
        registrationSteps.restorePassword(email, TestData.getRandomEmail());
    }

    @Test
    public void restorePasswordNegative() {
        registrationSteps.restorePassword(TestData.getRandomEmail(), TestData.getRandomEmail());
    }
}
