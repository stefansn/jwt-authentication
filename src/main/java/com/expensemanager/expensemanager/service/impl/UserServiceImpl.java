package com.expensemanager.expensemanager.service.impl;

import com.expensemanager.expensemanager.model.User;
import com.expensemanager.expensemanager.repository.UserRepository;
import com.expensemanager.expensemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final String DEFAULT_ROLE = "user";
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (user.getRole()==null)
            user.setRole(DEFAULT_ROLE);
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
