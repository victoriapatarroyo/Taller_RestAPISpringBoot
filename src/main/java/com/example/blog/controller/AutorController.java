package com.example.blog.controller;

import com.example.blog.model.Autor;
import com.example.blog.model.Posteo;
import com.example.blog.service.IautorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
	private final IautorService autorService;
	
	public AutorController(IautorService autorService) {
		this.autorService = autorService;
	}
	
	@GetMapping
	public List<Autor> listarAutores() {
		return autorService.obtenerTodosAutores();
	}
	
	@PostMapping("/crear")
	public Autor crearAutor(@RequestBody Autor autor) {
		return autorService.guardarAutor(autor);
	}
	
	@GetMapping("/{id}")
	public Autor obtenerAutor(@PathVariable Long id) {
		return autorService.obtenerAutorPorId(id)
				       .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
	}
	
	@PostMapping("/{id}/post")
	public Autor agregarPosteo(
			@PathVariable Long id,
			@RequestBody Posteo posteo) {
		
		return autorService.agregarPosteo(id, posteo);
	}
	
}
