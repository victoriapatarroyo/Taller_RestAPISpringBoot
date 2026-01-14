package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="autor")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAutor;
	private String nombreAutor;
	private String emailAutor;
	
	@OneToMany(mappedBy = "autorAsociado")
	@JsonManagedReference
	private List<Posteo> posteos;
	
	public Autor() {
	}
	
	public Autor(Long idAutor, String nombreAutor, String emailAutor) {
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor;
		this.emailAutor = emailAutor;
	}
	
	public Long getIdAutor() {
		return idAutor;
	}
	
	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}
	
	public String getNombreAutor() {
		return nombreAutor;
	}
	
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	
	public String getEmailAutor() {
		return emailAutor;
	}
	
	public void setEmailAutor(String emailAutor) {
		this.emailAutor = emailAutor;
	}
	
	public List<Posteo> getPosteos() {
		return posteos;
	}
	
	public void setPosteos(List<Posteo> posteos) {
		this.posteos = posteos;
	}
}
