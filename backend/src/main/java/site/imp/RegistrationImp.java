package site.imp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import site.interfaces.user.RegistrationInterface;
import site.model.user.Credential;
import site.repositories.CredentialRepository;
import site.repositories.UserRepository;

import java.util.Optional;

@Slf4j
@Component
public class RegistrationImp implements RegistrationInterface {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public ResponseEntity<?> createUser(String email, String password) {
        Optional<Credential> optionalCredential = credentialRepository.findById(email);
        if (optionalCredential.isPresent()) {
            return ResponseEntity.badRequest().body("Email registered");
        } else {
            credentialRepository.save(new Credential(email, password));
            return ResponseEntity.ok().build();
        }
    }

    @Override
    public ResponseEntity<?> restorePassword(String email, String password) {
        Optional<Credential> optionalCredential = credentialRepository.findById(email);
        if (optionalCredential.isPresent()) {
            Credential credential = optionalCredential.get();
            credential.setPassword(password);
            credentialRepository.save(credential);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Email not registered");
        }
    }
}
