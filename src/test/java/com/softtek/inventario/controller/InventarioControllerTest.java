/**
 * 
 */
package com.softtek.inventario.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.softtek.inventario.entity.Libro;
import com.softtek.inventario.service.LibroService;

/**
 * @author andres.espinosa
 *
 */
class InventarioControllerTest {
	

	private LibroService libroServiceMock = Mockito.mock(LibroService.class);
	
	@Autowired
	private InventarioController inventarioController = new InventarioController();
	
	private Libro libroAdd = new Libro(null,"José Saramago", "Ensayo sobre la cegera", "terror", "Punto de lectura","2001");

	@BeforeEach
	void setUp() throws Exception {
		
		List<Libro> libros =  new ArrayList<>();
		
		libros.add(new Libro(1,"Anne Rice", "Entrevista con el vampiro", "terror", "Tauro","2021"));
		libros.add(new Libro(2,"José Saramago", "Ensayo sobre la cegera", "terror", "Punto de lectura","2001"));
		Libro libro = new Libro(3,"José Saramago", "Ensayo sobre la cegera", "terror", "Punto de lectura","2001");

		Mockito.when(libroServiceMock.obtenLibros()).thenReturn(libros);
		Mockito.when(libroServiceMock.agregaLibro(libroAdd)).thenReturn(libro);
	}

	
	@Test
	void obtenLibros() {
		inventarioController.libroService = libroServiceMock;
		
		ResponseEntity<List<Libro>> resp = inventarioController.obtenLibro();
		
		System.out.println(resp.getStatusCode());
		
		System.out.println(resp.getBody().getClass());
		
		
		
		assertEquals("200 OK", resp.getStatusCode().toString());
		assertEquals("Anne Rice", resp.getBody().get(0).getAutor());
		
	
	}

	
	@Test
	void agregaLibro() {
		
	inventarioController.libroService = libroServiceMock;
		
		ResponseEntity<Libro> resp = inventarioController.guardaLibro(libroAdd);
		
		assertEquals("200 OK", resp.getStatusCode().toString());
		
		assertEquals(3, resp.getBody().getId());
		assertEquals("Ensayo sobre la cegera", resp.getBody().getTitulo());
		assertEquals("José Saramago", resp.getBody().getAutor());
	}
	
}
