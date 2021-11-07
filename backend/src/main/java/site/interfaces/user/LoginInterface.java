package site.interfaces.user;

import org.springframework.http.ResponseEntity;

public interface LoginInterface {

    ResponseEntity<?> login(String email, String password);
}
