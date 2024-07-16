package com.kapasiya.blogapp.serviceImpl;

import com.kapasiya.blogapp.entities.Blog;
import com.kapasiya.blogapp.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BlogService implements com.kapasiya.blogapp.service.BlogService
{

    @Autowired
    BlogRepo blogRepo;

    @Override
    public void saveBlog(Blog blog)
    {
        blogRepo.save(blog);
    }

    @Override
    public Blog findBlogById(Long id)
    {
        return blogRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Blog> getAllBlogs()
    {
        List<Blog> blog = blogRepo.findAll();
        return blog;
    }

    @Override
    public void deleteBlog(Long id)
    {
        blogRepo.deleteById(id);
    }
}
