package com.kapasiya.blogapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String email;

    private String userName;

    @Column(unique = true, nullable = false)
    private String password;

    public User() {
    }

    public User(long userId, String userEmail, String userName, String password) {
        this.userId = userId;
        this.email = userEmail;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmail='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}