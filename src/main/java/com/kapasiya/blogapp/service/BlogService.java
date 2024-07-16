package com.kapasiya.blogapp.service;

import com.kapasiya.blogapp.entities.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService
{
    void saveBlog(Blog blog);

    Blog findBlogById(Long id);

    List<Blog> getAllBlogs();

    void deleteBlog(Long id);

}
