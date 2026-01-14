package com.example.blog.service;

import com.example.blog.model.Comentario;
import com.example.blog.repository.IcomentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService implements IcomentarioService{
	private final IcomentarioRepository comentarioRepository;
	
	@Autowired
	public ComentarioService(IcomentarioRepository comentarioRepository) {
		this.comentarioRepository = comentarioRepository;
	}
	
	@Override
	public List<Comentario> obtenerTodosComentarios() {
		return comentarioRepository.findAll();
	}
	
	@Override
	public Optional<Comentario> obtenerComentarioPorId(Long id) {
		return comentarioRepository.findById(id);
	}
	
	@Override
	public Comentario guardarComentario(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}
	
	@Override
	public void borrarComentario(Long id) {
		comentarioRepository.deleteById(id);
	}
	
	@Override
	public Comentario editarComentario(Long id, Comentario comentarioActualizado) {
		Comentario comentarioExistente = comentarioRepository.findById(id)
				                                 .orElseThrow(() -> new RuntimeException("Comentario no encontrado con id: " + id));
		
		comentarioExistente.setTextoComentario((comentarioActualizado.getTextoComentario()));
		return comentarioRepository.save(comentarioExistente);
	}
	
	@Override
	public List<Comentario> obtnerComentarioPorPosteo(Long idPosteo) {
		return comentarioRepository.findByPosteoAsociado_IdPosteo(idPosteo);
	}
}
