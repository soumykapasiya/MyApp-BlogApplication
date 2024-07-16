package com.kapasiya.blogapp.repository;

import com.kapasiya.blogapp.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo extends JpaRepository<Blog, Long>
{
    Blog findById(long id);
}
