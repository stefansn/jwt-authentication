package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id) throws ResourceNotFoundException;

    User save(User user);

    void delete(Long id);

    Optional<User> findByUsername(String username);
}
