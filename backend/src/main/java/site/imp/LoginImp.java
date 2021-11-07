package site.imp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import site.interfaces.user.LoginInterface;
import site.interfaces.user.RegistrationInterface;
import site.model.user.Credential;
import site.model.user.Person;
import site.repositories.CredentialRepository;
import site.repositories.UserRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@Component
public class LoginImp implements LoginInterface {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public ResponseEntity<?> login(String email, String password) {
        Optional<Credential> optionalCredential = credentialRepository.findById(email);
        if (optionalCredential.isEmpty()) {
            return ResponseEntity.badRequest().body("Bad credential");
        } else if (!optionalCredential.get().getPassword().equals(password)) {
            return ResponseEntity.badRequest().body("Bad credential");
        } else {
//            optionalCredential.get().getLogin(
            return ResponseEntity.ok().build();
        }
    }
}
