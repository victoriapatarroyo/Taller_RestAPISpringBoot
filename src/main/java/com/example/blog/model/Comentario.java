package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.util.Date;

@Entity
@Table(name = "comentario")
public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComentario;
	private String textoComentario;
	private Date fechaCreado;
	
	@ManyToOne
	@JoinColumn(name="idPosteo")
	//@JsonBackReference
	@JsonIgnore
	private Posteo posteoAsociado;
	
	public Comentario() {
	}
	
	public Comentario(String textoComentario, Date fechaCreado) {
		this.textoComentario = textoComentario;
		this.fechaCreado = fechaCreado;
	}
	
	public Long getIdComentario() {
		return idComentario;
	}
	
	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}
	
	public String getTextoComentario() {
		return textoComentario;
	}
	
	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}
	
	public Date getFechaCreado() {
		return fechaCreado;
	}
	
	public void setFechaCreado(Date fechaCreado) {
		this.fechaCreado = fechaCreado;
	}
	
	public Posteo getPosteoAsociado() {
		return posteoAsociado;
	}
	
	public void setPosteoAsociado(Posteo posteoAsociado) {
		this.posteoAsociado = posteoAsociado;
	}
}
