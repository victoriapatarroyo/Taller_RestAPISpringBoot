package com.example.blog.repository;

import com.example.blog.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IcomentarioRepository extends JpaRepository<Comentario, Long> {
	List<Comentario> findByPosteoAsociado_IdPosteo(Long idPosteo);
}
