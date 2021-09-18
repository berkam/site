package site.interfaces.user;

import org.springframework.http.ResponseEntity;

public interface RegistrationInterface {

    ResponseEntity<?> createUser(String email, String password);

    ResponseEntity<?> restorePassword(String email, String password);
}
