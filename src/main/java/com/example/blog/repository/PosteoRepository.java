/*package com.example.blog.repository;

import com.example.blog.model.Posteo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PosteoRepository implements IposteoRepository{
    private final List<Posteo> posteos =new ArrayList<>();

    public PosteoRepository() {
        posteos.add(new Posteo(1L, "Bienestar", "Maria Díaz"));
        posteos.add((new Posteo(2L, "Ejercicio", "Patry Jordan")));
    }

    @Override
    public List<Posteo> findAll() {
        return posteos;
    }

    @Override
    public Posteo findById(Long id) {
        for(Posteo posteo: posteos) {
            if(posteo.getIdPosteo().equals(id)){
                return posteo;
            }
        }
        return null;
    }

    @Override
    public void save(Posteo posteo) {
        posteos.add(posteo);
    }
}
*/