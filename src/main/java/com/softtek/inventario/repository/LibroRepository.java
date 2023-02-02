package com.softtek.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.inventario.entity.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{

}

