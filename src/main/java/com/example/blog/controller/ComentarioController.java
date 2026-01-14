package com.example.blog.controller;

import com.example.blog.model.Comentario;
import com.example.blog.model.Posteo;
import com.example.blog.service.IcomentarioService;
import com.example.blog.service.IposteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
	
	private final IcomentarioService comentarioService;
	private final IposteoService posteoService;
	
	@Autowired
	public ComentarioController(IcomentarioService comentarioService, IposteoService posteoService) {
		this.comentarioService = comentarioService;
		this.posteoService = posteoService;
	}
	
	// Obtener todos los comentarios
	@GetMapping
	public ResponseEntity<List<Comentario>> listarComentarios() {
		return ResponseEntity.ok(comentarioService.obtenerTodosComentarios());
	}
	
	// Obtener comentarios de un posteo específico
	@GetMapping("/posteo/{idPosteo}")
	public ResponseEntity<List<Comentario>> obtenerComentariosDePosteo(@PathVariable Long idPosteo) {
		List<Comentario> comentarios = comentarioService.obtnerComentarioPorPosteo(idPosteo);
		return ResponseEntity.ok(comentarios);
	}
	
	// Obtener un comentario por ID
	@GetMapping("/{id}")
	public ResponseEntity<Comentario> obtenerComentario(@PathVariable Long id) {
		Comentario comentario = comentarioService.obtenerComentarioPorId(id)
				                        .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
		return ResponseEntity.ok(comentario);
	}
	
	// Crear comentario en un posteo
	@PostMapping("/posteo/{idPosteo}")
	public ResponseEntity<Comentario> agregarComentario(
			@PathVariable Long idPosteo,
			@RequestBody Comentario comentario) {
		
		// Buscar el posteo
		Posteo posteo = posteoService.obtenerPorid(idPosteo)
				                .orElseThrow(() -> new RuntimeException("Posteo no encontrado con id: " + idPosteo));
		
		// Asociar el comentario al posteo
		comentario.setPosteoAsociado(posteo);
		
		// Guardar el comentario
		Comentario comentarioGuardado = comentarioService.guardarComentario(comentario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(comentarioGuardado);
	}
	
	// Editar comentario
	@PutMapping("/editar/{id}")
	public ResponseEntity<Comentario> editarComentario(
			@PathVariable Long id,
			@RequestBody Comentario comentario) {
		Comentario comentarioActualizado = comentarioService.editarComentario(id, comentario);
		return ResponseEntity.ok(comentarioActualizado);
	}
	
	// Eliminar comentario
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminarComentario(@PathVariable Long id) {
		comentarioService.obtenerComentarioPorId(id)
				.orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
		
		comentarioService.borrarComentario(id);
		return ResponseEntity.ok("Comentario eliminado con éxito");
	}
}
