package site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import site.model.user.Credential;

public interface CredentialRepository extends JpaRepository<Credential, String> {

}
