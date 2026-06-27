package com.github.wolfanyy.springbootusermanagement.repository;

import com.github.wolfanyy.springbootusermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
