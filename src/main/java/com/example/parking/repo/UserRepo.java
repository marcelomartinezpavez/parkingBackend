package com.example.parking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.parking.model.User;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
  Optional<User> findByUsers(String username);
}
