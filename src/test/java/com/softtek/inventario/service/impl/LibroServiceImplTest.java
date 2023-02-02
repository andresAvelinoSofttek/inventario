/**
 * 
 */
package com.softtek.inventario.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtek.inventario.entity.Libro;
import com.softtek.inventario.repository.LibroRepository;

/**
 * @author andres.espinosa
 *
 */
class LibroServiceImplTest {
	
	//@Autowired
	LibroRepository libroRepositoryMock = Mockito.mock(LibroRepository.class);
	
	@Autowired
	private LibroServiceImpl libroServiceImpl =  new LibroServiceImpl();
	
	private Libro libroAdd = new Libro(null,"José Saramago", "Ensayo sobre la cegera", "terror", "Punto de lectura","2001");
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		List<Libro> libros =  new ArrayList<>();
		
		libros.add(new Libro(1,"Anne Rice", "Entrevista con el vampiro", "terror", "Tauro","2021"));
		libros.add(new Libro(2,"José Saramago", "Ensayo sobre la cegera", "terror", "Punto de lectura","2001"));
		Libro libro = new Libro(3,"José Saramago", "Ensayo sobre la cegera", "terror", "Punto de lectura","2001");
		
		Mockito.when(libroRepositoryMock.findAll()).thenReturn(libros);
		Mockito.when(libroRepositoryMock.save(libroAdd)).thenReturn(libro);
	}
	
	@Test
	void obtenLibros() {
		libroServiceImpl.libroRepository = libroRepositoryMock;
		List<Libro> libros = libroServiceImpl.obtenLibros();
		
		assertEquals(2, libros.size());
	}

	
	@Test
	void agregaLibro() {
		libroServiceImpl.libroRepository = libroRepositoryMock;
	
		Libro libroResp = libroServiceImpl.agregaLibro(libroAdd);
		
		System.out.print(libroResp);
		
		assertEquals(3, libroResp.getId());
		assertEquals("Ensayo sobre la cegera", libroResp.getTitulo());
		assertEquals("José Saramago", libroResp.getAutor());
	}
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//		
//		//Assertions.
//	}

}
