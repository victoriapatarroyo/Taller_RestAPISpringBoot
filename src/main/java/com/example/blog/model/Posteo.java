package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="posteo")
public class Posteo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosteo;
    private String titulo;
	
	
	@ManyToOne
	@JoinColumn(name="idAutor")
	@JsonBackReference
	private Autor autorAsociado;
	
	
	@OneToMany(mappedBy = "posteoAsociado", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JsonBackReference
	private List<Comentario> comentarios = new ArrayList<>();

    public Posteo() {
    }

    public Posteo(String titulo) {
        //this.idPosteo = idPosteo;
        this.titulo = titulo;
    }

    public Long getIdPosteo() {
        return idPosteo;
    }

    public void setIdPosteo(Long idPosteo) {
        this.idPosteo = idPosteo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

	public Autor getAutorAsociado() {
		return autorAsociado;
	}
	
	public void setAutorAsociado(Autor autorAsociado) {
		this.autorAsociado = autorAsociado;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
}
