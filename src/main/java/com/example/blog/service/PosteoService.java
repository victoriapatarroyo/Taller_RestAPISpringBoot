package com.example.blog.service;

import com.example.blog.model.Posteo;
import com.example.blog.repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IposteoService{
    private final IposteoRepository posteoRepository;

    @Autowired
    public PosteoService(IposteoRepository posteoRepository) {
        this.posteoRepository = posteoRepository;
    }

    @Override
    public List<Posteo> obtenerTodos() {
        return posteoRepository.findAll();
    }

    @Override
    public Optional<Posteo> obtenerPorid(Long id) {
        return posteoRepository.findById(id);
    }

    @Override
    public void guardarPosteo(Posteo posteo) {
        posteoRepository.save(posteo);
    }

    @Override
    public void deletePosteo(Long id) {
        posteoRepository.deleteById(id);
    }

    @Override
    public void editarPosteo(Long id, Posteo personaActualizada) {
        //Saber si exsite
        Posteo personaExistente = posteoRepository.findById(id).orElse(null);

        if (personaExistente != null){
            //Actualizar los campos de persona existente
            personaExistente.setTitulo(personaActualizada.getTitulo());
            //personaExistente.setAutor(personaActualizada.getAutor());

            // Guardo a la persona actualziada
            posteoRepository.save(personaExistente);
        } else {
            throw new RuntimeException("Posteo no encontrado con el id: " + id);
        }
    }}
