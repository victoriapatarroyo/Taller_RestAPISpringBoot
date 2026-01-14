package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="posteo")
public class Posteo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosteo;
    private String titulo;
    //private String autorPosteo;
	
	@ManyToOne
	@JoinColumn(name="idAutor")
	@JsonBackReference
	private Autor autorAsociado;
	
	@OneToMany(mappedBy = "posteoAsociado", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JsonBackReference
	@JsonManagedReference
	private List<Comentario> comentarios;

    public Posteo() {
    }

    public Posteo(Long idPosteo, String titulo) {
        this.idPosteo = idPosteo;
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
