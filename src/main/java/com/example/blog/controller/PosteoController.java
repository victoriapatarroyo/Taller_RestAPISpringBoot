package com.example.blog.controller;

import com.example.blog.model.Posteo;
import com.example.blog.service.PosteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posteos")
public class PosteoController {
    private final PosteoService posteoService;

    @Autowired
    public PosteoController(PosteoService posteoService) {
        this.posteoService = posteoService;
    }

    @GetMapping
    public List<Posteo> listarPosteos() {
        return posteoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Posteo> obtenerPorId(@PathVariable Long id) {
        return posteoService.obtenerPorid(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> salvarPosteo(@RequestBody Posteo posteo) {
        posteoService.guardarPosteo(posteo);
        return ResponseEntity.ok("Post salvado correctamente");
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<String> deletePosteo(@PathVariable Long id) {
        posteoService.deletePosteo(id);
        return ResponseEntity.ok("Posteo eliminado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPersonas(@PathVariable Long id, @RequestBody Posteo posteoActualizado){
        posteoService.editarPosteo(id, posteoActualizado);
        return  ResponseEntity.ok("Posteo actualizado con exito");
    }
}
