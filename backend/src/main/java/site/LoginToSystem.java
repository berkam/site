package site;

import org.springframework.stereotype.Controller;
import site.model.user.Credential;
import site.repositories.CredentialRepository;

@Controller
public record LoginToSystem(CredentialRepository credentialRepository) {

    boolean checkUser(String login, String password) {
        Credential credential = credentialRepository.findByLogin(login);
        if (credential != null) {
            return credential.getPassword().equals(password);
        }
        return false;
    }
}
