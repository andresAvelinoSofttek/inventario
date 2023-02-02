package com.softtek.inventario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity(name = "Libro_detalle")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String autor;
	private String titulo;
	private String genero;
	private String editorial;
	private String edicion;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getEdicion() {
		return edicion;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", autor=" + autor + ", titulo=" + titulo + ", genero=" + genero + ", editorial="
				+ editorial + ", edicion=" + edicion + "]";
	}
	public Libro(Integer id, String autor, String titulo, String genero, String editorial, String edicion) {
		super();
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.genero = genero;
		this.editorial = editorial;
		this.edicion = edicion;
	}
	public Libro() {

	}

}
