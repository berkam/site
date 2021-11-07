package site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import site.model.user.Credential;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, String> {

    @Query("select c from Credential c where c.login = :login")
    Credential findByLogin(@Param("login") String login);
}
