package com.expensemanager.expensemanager.security;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.model.User;
import com.expensemanager.expensemanager.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        try {
            return userService.findByUsername(username)
                    .map(this::getUserDetails)
                    .orElseThrow(() -> new ResourceNotFoundException(String.format("Username: %s not found", username)));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private org.springframework.security.core.userdetails.User getUserDetails(User u) {
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(),
                u.getPassword(),
                getGrantedAuthorities(u));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User u) {
        return AuthorityUtils
                .commaSeparatedStringToAuthorityList(u.getRole());
    }
}
