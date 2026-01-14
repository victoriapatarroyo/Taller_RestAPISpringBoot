package com.example.blog.service;

import com.example.blog.model.Post;
import com.example.blog.model.Posteo;
import com.example.blog.repository.IpostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IpostService{
    private final IpostRepository postRepository;

    @Autowired
    public PostService(IpostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> obtenerTodosPost() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> obtenerPostPorId(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void guardarPost(Post post) {
        if (post.getTitulo() == null || post.getTitulo().isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }

        // Validar contenido
        if (post.getContenido() == null || post.getContenido().isBlank()) {
            throw new IllegalArgumentException("El contenido no puede estar vacío");
        }

        if(post.getContenido().length() > 200) {
            throw new IllegalArgumentException("El contenido no puede tener más de 200 caracteres");
        }

        // Validar fecha - Si es null, asignar fecha actual
        if (post.getFechaCreacion() == null) {
            post.setFechaCreacion(LocalDate.now());
        }

        postRepository.save(post);
    }

    @Override
    public boolean borrarPost(Long id) {
        Post postExistente = postRepository.findById(id).orElse(null);

        if(postExistente != null) {
            postRepository.deleteById(id);
            return true;
        } else {
            //throw new RuntimeException("Post no encontrado con el id: " + id);
            return false;
        }
    }

    @Override
    public boolean editarPost(Long id, Post postActualizado) {
        //Saber si exsite
        Post postExistente = postRepository.findById(id).orElse(null);

        if (postExistente != null){
            //Actualizar los campos de post existente
            postExistente.setTitulo(postActualizado.getTitulo());
            postExistente.setContenido(postActualizado.getContenido());
            postExistente.setFechaCreacion(postActualizado.getFechaCreacion());

            postRepository.save(postExistente);
            return true;
        } else {
            //throw new RuntimeException("Post no encontrado con el id: " + id);
            return false;
        }
    }}
