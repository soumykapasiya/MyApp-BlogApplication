package com.kapasiya.blogapp.serviceImpl;

import com.kapasiya.blogapp.dto.UserLoginDTO;
import com.kapasiya.blogapp.dto.UserRegisteredDTO;
import com.kapasiya.blogapp.entities.User;
import com.kapasiya.blogapp.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements com.kapasiya.blogapp.service.LoginService
{

    @Autowired
    LoginRepo loginRepo;


    @Override
    public void saveUser(UserRegisteredDTO userRegisteredDTO)
    {
        User user = new User();

        user.setUserName(userRegisteredDTO.getUserName());
        user.setPassword(userRegisteredDTO.getPassword());
        user.setEmail(userRegisteredDTO.getEmail());

        loginRepo.save(user);
    }

    //
    @Override
    public User loginUser(UserLoginDTO userLoginDTO)
    {
        return null;
    }

}
