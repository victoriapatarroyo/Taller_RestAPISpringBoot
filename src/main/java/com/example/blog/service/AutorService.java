package com.example.blog.service;

import com.example.blog.model.Autor;
import com.example.blog.model.Posteo;
import com.example.blog.repository.IautorRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements IautorService{
	private final IautorRepository autorRepository;
	
	@Autowired
	public AutorService(IautorRepository autorRepository) {
		this.autorRepository = autorRepository;
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
		autorRepository.save(autor);
		return autor;
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
	public Autor agregarPosteo(Long autorId, Posteo posteo) {
		Autor autor = autorRepository.findById(autorId)
				              .orElseThrow(() -> new RuntimeException("Autor no encoentrado"));

		posteo.setAutorAsociado(autor);
		autor.getPosteos().add(posteo);

		return autorRepository.save(autor);
	}
}
