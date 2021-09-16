package site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import site.model.user.Credential;

public interface CredentialRepository extends JpaRepository<Credential, Long> {

    @Query("SELECT * FROM credential p WHERE login = :login")
    Credential findByLogin(@Param("login") String login);
}
