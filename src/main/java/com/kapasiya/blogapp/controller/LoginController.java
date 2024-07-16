package com.kapasiya.blogapp.controller;


import com.kapasiya.blogapp.dto.UserLoginDTO;
import com.kapasiya.blogapp.dto.UserRegisteredDTO;
import com.kapasiya.blogapp.entities.User;
import com.kapasiya.blogapp.repository.LoginRepo;
import com.kapasiya.blogapp.service.LoginService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController
{
    @Autowired
    LoginRepo loginRepo;

    @Autowired
    LoginService loginService;

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("userRegister", new UserRegisteredDTO());
        model.addAttribute("userLogin", new UserLoginDTO());
        return "index";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("userRegister") UserRegisteredDTO userRegister)
    {
//        String email = userRegister.getEmail();
        if (userRegister == null)
        {
            return "redirect:/?error";
        }
        loginService.saveUser(userRegister);
        // System.out.println(userRegister);

        return "redirect:/";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("userLogin") UserLoginDTO userLogin)
    {
        User user = loginRepo.findByEmail(userLogin.getEmail());

        if(user != null && user.getPassword().equals(userLogin.getPassword()))
        {
            return "home";
        }
        return "redirect:/?error";
    }
}
