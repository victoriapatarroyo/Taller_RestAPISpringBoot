package com.example.blog.service;

import com.example.blog.model.Comentario;

import java.util.List;
import java.util.Optional;

public interface IcomentarioService {
	List<Comentario> obtenerTodosComentarios();
	Optional<Comentario> obtenerComentarioPorId(Long id);
	Comentario guardarComentario(Comentario comentario);
	//void guardarComentario(Comentario comentario);
	
	//Metodo para eliminar un comentario
	void borrarComentario(Long id);
	
	//Metodo para editar un comentario
	Comentario editarComentario(Long id, Comentario comnetarioActualizado);
	
	List<Comentario> obtnerComentarioPorPosteo(Long idPosteo);
}
