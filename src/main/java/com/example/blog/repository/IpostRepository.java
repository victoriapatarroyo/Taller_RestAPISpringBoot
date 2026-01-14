package com.example.blog.repository;

import com.example.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpostRepository extends JpaRepository<Post, Long> {
}
