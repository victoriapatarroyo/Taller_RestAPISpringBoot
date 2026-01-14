package com.example.blog.service;

import com.example.blog.model.Comentario;

import java.util.List;
import java.util.Optional;

public interface IcomentarioService {
	List<Comentario> obtenerTodosComnetarios();
	Optional<Comentario> obtenerComentarioPorId(Long id);
	void guardarComentario(Comentario comnetario);
	
	//Metodo para eliminar un comentario
	void borrarComentario(Long id);
	
	//Metodo para editar un comentario
	void editarComentario(Long id, Comentario comnetarioActualizado);
}
