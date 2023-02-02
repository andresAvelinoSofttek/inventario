package com.softtek.inventario.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.inventario.entity.Libro;
import com.softtek.inventario.repository.LibroRepository;
import com.softtek.inventario.service.LibroService;

@Service("LibroService")
public class LibroServiceImpl implements LibroService{
	
	private static final Logger logger = LoggerFactory.getLogger(LibroServiceImpl.class);
	
	@Autowired
	LibroRepository libroRepository;

	@Override
	public List<Libro> obtenLibros() {
				
		List<Libro> libros = libroRepository.findAll();
		
		return libros;
	}
	
	@Override
	public Libro agregaLibro(Libro libro) {
		
		//libro.setId(null);
		
		Libro resultado =  libroRepository.save(libro);
		
		logger.info("El libro {} ha sido agregado ", resultado);
		
		return resultado;

	}

}
