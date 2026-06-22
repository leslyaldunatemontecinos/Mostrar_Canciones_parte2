package com.musica.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "canciones")
public class Cancion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//PARTE 2 
	// Titulo al menos 5 caracteres de longitud
	@Size(min = 5, message ="El titulo debe tener al menos 5 caracteres de longitud.")
	private String titulo;
	
	
	// Artista al menos 3 caracteres de longitud
	@Size(min = 3, message ="El artista debe tener al menos 3 caracteres de longitud.")
	private String artista;
	
	// Album al menos 3 caracteres de longitud
	@Size(min = 3, message ="El album debe tener al menos 3 caracteres de longitud.")
	private String album;
	
	// Artista al menos 3 caracteres de longitud
	@Size(min = 3, message ="El género debe tener al menos 3 caracteres de longitud.")
	private String genero;
	
	// Idioma al menos 3 caracteres de longitud
	@Size(min = 3, message ="El idioma debe tener al menos 3 caracteres de longitud.")
	private String idioma;

	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	// Constructor vacio
	public Cancion() {
}
	
	//Getters y Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	// MANEJO AUTOMATICO DE FECHAS
	//Esto ejecuta automaticamente justo antes de que se cree el registro
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
		this.updatedAt = new Date();		
	}
	
	//Esto se ejecuta autamticamente justo antes de que se modifique el registro
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
	
