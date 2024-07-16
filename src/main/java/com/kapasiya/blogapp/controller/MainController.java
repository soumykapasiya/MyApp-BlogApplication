package com.kapasiya.blogapp.controller;

import com.kapasiya.blogapp.entities.Blog;
import com.kapasiya.blogapp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController
{

    @Autowired
    BlogService blogService;

    @GetMapping("/home")
    public String home(Model model)
    {
        List<Blog> allBlogs = blogService.getAllBlogs();

        model.addAttribute("allBlogs", allBlogs);
        return "/home";
    }

    @GetMapping("/createBlog")
    public String createBlog(Model model)
    {
        model.addAttribute("blog", new Blog());

        return "createBlog";
    }

    @PostMapping({"/createBlog"})
    public String createBlog(@ModelAttribute("blogDetails") Blog blog, Model model)
    {
        blogService.saveBlog(blog);
        List<Blog> allBlogs = blogService.getAllBlogs();

        model.addAttribute("allBlogs", allBlogs);
        return "/home";
    }


    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id, Model model)
    {
        blogService.deleteBlog(id);
        List<Blog> allBlogs = blogService.getAllBlogs();
        model.addAttribute("allBlogs", allBlogs);
        return "/home";
    }

    @GetMapping("/update/{id}")
    public String updateBlog(@PathVariable Long id, Model model)
    {
        Blog blog = blogService.findBlogById(id);
//        System.out.println(blog);

        model.addAttribute("blog", blog);

        return "updateBlog";
    }

    @PostMapping("/update")
    public String finalUpdate(@RequestBody Blog blog, Model model)
    {
        System.out.println(blog);
        blogService.saveBlog(blog);

        return "redirect:/home";
    }

}