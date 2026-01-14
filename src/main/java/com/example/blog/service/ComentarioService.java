package com.example.blog.service;

import com.example.blog.model.Comentario;
import com.example.blog.repository.IcomentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ComentarioService implements IcomentarioService{
	private final IcomentarioRepository comentarioRepository;
	
	@Autowired
	public ComentarioService(IcomentarioRepository comentarioRepository) {
		this.comentarioRepository = comentarioRepository;
	}
	
		@Override
	public List<Comentario> obtenerTodosComnetarios() {
		return comentarioRepository.findAll();
	}
	
	@Override
	public Optional<Comentario> obtenerComentarioPorId(Long id) {
		return comentarioRepository.findById(id);
	}
	
	@Override
	public void guardarComentario(Comentario comentario) {
		comentarioRepository.save(comentario);
	}
	
	@Override
	public void borrarComentario(Long id) {
		comentarioRepository.deleteById(id);
	}
	
	@Override
	public void editarComentario(Long id, Comentario comnetarioActualizado) {
		//Saber si exsite
		Comentario comentarioExiste = comentarioRepository.findById(id).orElse(null);
		
		if (comentarioExiste != null){
			//Actualizar los campos de comentario existente
			comentarioExiste.setTextoComentario(comnetarioActualizado.getTextoComentario());
			
			// Guardo comentario actualizado
			comentarioRepository.save(comentarioExiste);
		} else {
			throw new RuntimeException("Comentario no encontrado con el id: " + id);
		}
		
	}
}
