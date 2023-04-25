package com.example.springjparelationlivelecture230425.repository;

import com.example.springjparelationlivelecture230425.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
