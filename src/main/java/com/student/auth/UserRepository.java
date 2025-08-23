package com.student.auth;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  List<User> findByUsernameAndPassword(String username, String password);

  @Query(value = "SELECT u.user_id FROM Users u ", nativeQuery = true)
  List<Long> findByIdOfAllUsers();
}
