package site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import site.model.user.Person;

public interface UserRepository extends JpaRepository<Person, Long> {
}
