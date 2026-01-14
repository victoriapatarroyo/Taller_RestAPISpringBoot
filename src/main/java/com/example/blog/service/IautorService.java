package com.example.blog.service;

import com.example.blog.model.Autor;
import com.example.blog.model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IautorService {
	List<Autor> obtenerTodosAutores();
	Optional<Autor> obtenerAutorPorId(Long id);
	Autor guardarAutor(Autor autor);
	
	//Metodo para eliminar un autor
	void borrarAutor(Long id);
	
	//Metodo para editar un autor
	void editarAutor(Long id, Autor autorActualizado);
	
	//Metodo para adiconar post
	Autor agregarPosteo(Long autorId, Posteo posteo);
}
