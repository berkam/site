package site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import site.model.user.Credential;

public interface CredentialRepository extends JpaRepository<Credential, Long> {

//    @Query("SELECT c.login, c.password FROM credential c WHERE c.login = :login")
//    Credential findByLogin(@Param("login") String login);
}
