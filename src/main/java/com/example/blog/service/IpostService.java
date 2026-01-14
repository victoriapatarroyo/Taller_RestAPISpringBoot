package com.example.blog.service;

import com.example.blog.model.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IpostService {
    List<Post> obtenerTodosPost();
    Optional<Post> obtenerPostPorId(Long id);
    void guardarPost(Post post);

    //Metodo para eliminar un poste
    boolean borrarPost(Long id);

    //Metodo para editar un post
    boolean editarPost(Long id, Post postActualizado);
}
