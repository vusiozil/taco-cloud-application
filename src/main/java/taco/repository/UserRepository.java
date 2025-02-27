package taco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taco.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
