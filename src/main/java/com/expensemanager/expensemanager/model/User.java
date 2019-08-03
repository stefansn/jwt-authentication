package com.expensemanager.expensemanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Provide a username")
    private String username;
    @NotBlank(message = "Provide a password")
    private String password;
    private String role;

    public User(){

    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="role", nullable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
