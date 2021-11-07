package site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
