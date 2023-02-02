package com.softtek.inventario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.softtek.inventario.entity.Libro;
import com.softtek.inventario.service.LibroService;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/mssofttek-libros")
public class InventarioController {
	
	private static final Logger logger = LoggerFactory.getLogger(InventarioController.class);
	
	@Autowired
	LibroService libroService;
	
	@GetMapping("/")
	public ResponseEntity<List<Libro>> obtenLibro() {
		logger.info("Consultando libros");
		
		List<Libro>  resultado = libroService.obtenLibros();
		
		if(resultado == null){
			return new ResponseEntity<>(NO_CONTENT);
		}else {
			return new ResponseEntity<>(resultado, OK);
		}
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Libro>  guardaLibro(@RequestBody Libro libro) {
		logger.info("Agregando libro");
		
		Libro resultado =  libroService.agregaLibro(libro);
		
		if(resultado == null){
			return new ResponseEntity<>(NO_CONTENT);
		}else {
			return new ResponseEntity<>(resultado, OK);
		}
		
	}
	
	

}
