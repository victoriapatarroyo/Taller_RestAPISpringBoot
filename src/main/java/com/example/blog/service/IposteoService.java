package com.example.blog.service;

import com.example.blog.model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IposteoService {
    List<Posteo> obtenerTodos();
    Optional<Posteo> obtenerPorid(Long id);
    void guardarPosteo(Posteo posteo);

    //Metodo para eliminar un posteo
    void deletePosteo(Long id);

    //Metodo para editar un posteo
    void editarPosteo(Long id, Posteo posteoActualizado);
}
