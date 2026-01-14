package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> listarPost() {
        return postService.obtenerTodosPost();
    }

    @GetMapping("/{id}")
    public Optional<Post> obtenerPostPorId(@PathVariable Long id) {
        return postService.obtenerPostPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarPost(@RequestBody Post post) {
        try {
            postService.guardarPost(post);
            return ResponseEntity.ok("Post guardado correctamente");
        } catch (IllegalArgumentException e) {
            // Retornar error 400 con mensaje descriptivo
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error.toString());
        }
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<String> borrarPost(@PathVariable Long id) {
        boolean eliminado = postService.borrarPost(id);

        if (eliminado) {
            return ResponseEntity.ok("Post eliminado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post no encontrado con el id: " + id);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPost(@PathVariable Long id, @RequestBody Post postActualizado){
        boolean actualizado = postService.editarPost(id, postActualizado);

        if(actualizado) {
            return ResponseEntity.ok("Post actualizado con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post no encontrado con el id: " + id);
        }
    }
}
