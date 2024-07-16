package com.kapasiya.blogapp.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisteredDTO
{
    private long userID;

    private String email;

    private String userName;

    private String password;
}
