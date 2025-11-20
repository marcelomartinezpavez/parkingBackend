package com.example.parking.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsers(String users);

    Optional<User> findByUsersAndPass(String users, String pass);
}
