package site.imp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import site.repositories.CredentialRepository;
import site.repositories.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RegistrationImpTest {

    @Autowired
    private RegistrationImp registrationImp;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CredentialRepository credentialRepository;

    @Test
    void createUser() {
        ResponseEntity<?> responseEntity = registrationImp.createUser("Email", "Pass");
        assertThat(responseEntity.getStatusCode())
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    void restorePassword() {
    }
}