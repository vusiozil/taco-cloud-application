package taco.repository;

import org.springframework.data.repository.CrudRepository;
import taco.domain.User;

public interface UserRepository extends CrudRepository<User,Long> {

  void deleteUserByUsername(String username);

//  void changePassword(String oldPassword, String newPassword);

  boolean existsByUsername(String username);

  User findByUsername(String username);

//  List<User> FindAll();
}
