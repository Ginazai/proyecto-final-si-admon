package com.dashboard.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contenido")
public class ContenidoEntidad {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="image")
	private String image;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="contenido", columnDefinition = "TEXT")
	private String contenido;
	
	
	//constructores
	public ContenidoEntidad() {
		super();
	}
	
	public ContenidoEntidad(String categoria, String image, String titulo, String contenido) {
		super();
		this.categoria = categoria;
		this.image = image;
		this.titulo = titulo;
		this.contenido = contenido;
	}


	//Getters & Setters
	public Long getId() {
		return id;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

}
