package site.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import site.interfaces.user.RegistrationInterface;
import site.model.user.Credential;
import site.model.user.User;
import site.repositories.CredentialRepository;
import site.repositories.UserRepository;

import java.math.BigDecimal;
import java.util.Optional;

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
            Credential credential = new Credential(email, password);
            User user = new User(null, BigDecimal.ZERO);
            user = userRepository.save(user);
            credential.setUser(user);
            user.setCredential(credential);
            credentialRepository.save(credential);
            userRepository.save(user);
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
