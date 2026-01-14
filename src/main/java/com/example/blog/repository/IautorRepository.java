package com.example.blog.repository;

import com.example.blog.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IautorRepository extends JpaRepository<Autor, Long> {
}
