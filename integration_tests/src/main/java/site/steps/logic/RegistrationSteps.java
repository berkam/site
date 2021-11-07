package site.steps.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.model.user.Credential;
import site.repositories.CredentialRepository;
import site.repositories.UserRepository;
import site.steps.wrapper.RegistrationWrapperSteps;

import static org.assertj.core.api.Assertions.assertThat;

@Component
public class RegistrationSteps {

    @Autowired
    private RegistrationWrapperSteps registrationSteps;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CredentialRepository credentialRepository;

    public void checkUserExists(String email, String password) {
        Credential credential = credentialRepository.findByLogin(email);
        assertThat(credential.getLogin())
                .isEqualTo(email);
        assertThat(credential.getPassword())
                .isEqualTo(password);
        assertThat(credential.getUser())
                .isNotNull();
    }
}
