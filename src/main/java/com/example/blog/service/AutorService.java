package com.example.blog.service;

import com.example.blog.model.Autor;
import com.example.blog.model.Posteo;
import com.example.blog.repository.IautorRepository;
import com.example.blog.repository.IposteoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements IautorService{
	private final IautorRepository autorRepository;
	private final IposteoRepository posteoRepository;
	
	@Autowired
	public AutorService(IautorRepository autorRepository, IposteoRepository posteoRepository) {
		this.autorRepository = autorRepository;
		this.posteoRepository = posteoRepository;
	}
	
	@Override
	public List<Autor> obtenerTodosAutores() {
		return autorRepository.findAll();
	}
	
	@Override
	public Optional<Autor> obtenerAutorPorId(Long id) {
		return autorRepository.findById(id);
	}
	
	@Override
	public Autor guardarAutor(Autor autor) {
		return autorRepository.save(autor);
	}
	
	@Override
	public void borrarAutor(Long id) {
		autorRepository.deleteById(id);
	}
	
	@Override
	public void editarAutor(Long id, Autor autorActualizado) {
		//Saber si exsite
		Autor autorExiste = autorRepository.findById(id).orElse(null);
		
		if (autorExiste != null){
			//Actualizar los campos de autor existente
			autorExiste.setEmailAutor(autorActualizado.getEmailAutor());
			
			// Guardo autor actualizado
			autorRepository.save(autorExiste);
		} else {
			throw new RuntimeException("Autor no encontrado con el id: " + id);
		}
	}
	
	@Override
	@Transactional
	public Autor agregarPosteo(Long autorId, Posteo posteo) {
		Autor autor = autorRepository.findById(autorId)
				              .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
		
		posteo.setAutorAsociado(autor);
		
		posteoRepository.save(posteo);
		
		return autorRepository.findById(autorId)
				       .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
	}
}
