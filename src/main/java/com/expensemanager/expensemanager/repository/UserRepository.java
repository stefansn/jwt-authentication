package com.expensemanager.expensemanager.repository;

import com.expensemanager.expensemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
