package com.softtek.inventario.model;

import lombok.Data;

@Data
public class Libro {
	
	private Integer id;
	
	private String autor;
	private String titulo;
	private String genero;
	private String editorial;
	private String añoEdicion;

}
