package com.kapasiya.blogapp.controller;


import com.kapasiya.blogapp.dto.UserLoginDTO;
import com.kapasiya.blogapp.dto.UserRegisteredDTO;
import com.kapasiya.blogapp.entities.Blog;
import com.kapasiya.blogapp.entities.User;
import com.kapasiya.blogapp.repository.LoginRepo;
import com.kapasiya.blogapp.service.BlogService;
import com.kapasiya.blogapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController
{
    @Autowired
    LoginRepo loginRepo;

    @Autowired
    BlogService blogService;

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
    public String loginUser(@ModelAttribute("userLogin") UserLoginDTO userLogin,Model model)
    {
        User user = loginRepo.findByEmail(userLogin.getEmail());

        List<Blog> allBlogs = blogService.getAllBlogs();

        model.addAttribute("allBlogs", allBlogs);
        if(user != null && user.getPassword().equals(userLogin.getPassword()))
        {
            return "home";
        }
        return "redirect:/?error";
    }
}
