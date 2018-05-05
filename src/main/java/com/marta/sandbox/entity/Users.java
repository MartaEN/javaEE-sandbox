package com.marta.sandbox.entity;

import com.marta.sandbox.enums.UserRole;

import javax.persistence.*;


@Entity
public class Users extends AbstractEntity {

    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @Column(nullable = false, columnDefinition = "TINYTEXT")
    private String password;

    @Column(nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public Users() { }

    public Users(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
