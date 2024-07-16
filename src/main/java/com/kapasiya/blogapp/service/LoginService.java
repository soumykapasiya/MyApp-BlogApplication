package com.kapasiya.blogapp.service;

import com.kapasiya.blogapp.dto.UserLoginDTO;
import com.kapasiya.blogapp.dto.UserRegisteredDTO;
import com.kapasiya.blogapp.entities.User;
import org.springframework.stereotype.Repository;


public interface LoginService
{
    public void saveUser(UserRegisteredDTO userRegisteredDTO);

    public User loginUser(UserLoginDTO userLoginDTO);
}
