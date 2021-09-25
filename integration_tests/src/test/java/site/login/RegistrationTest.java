package site.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.steps.RegistrationSteps;
import site.utils.TestData;

@SpringBootTest
public class RegistrationTest {

    @Autowired
    RegistrationSteps registrationSteps;

    @Test
    public void createUser() {
        registrationSteps.createUser(TestData.getRandomEmail(), TestData.getRandomEmail());
    }
}
