package com.softtek.inventario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.softtek.inventario.entity.Libro;

@Service
public interface LibroService {
	
	List<Libro>  obtenLibros();

	Libro agregaLibro(Libro libro);

}
