package com.github.wolfanyy.springbootusermanagement.repository;

import com.github.wolfanyy.springbootusermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
