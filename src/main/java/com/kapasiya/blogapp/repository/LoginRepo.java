package com.kapasiya.blogapp.repository;

import com.kapasiya.blogapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<User, Long>
{
    User findByEmail(String email);
}
