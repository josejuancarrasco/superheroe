package com.example.superheroe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.superheroe.modelo.SuperHeroe;

public interface SuperHeroeRepositorio extends JpaRepository<SuperHeroe, Long>{
	
	public SuperHeroe findFirstById(Long id);
	
	/**
	 * Busca todos los superheroes que contengan lo pasado por parámetro.
	 * @param nombre
	 * @return
	 */
	@Query("select sh from SuperHeroe sh where sh.nombre like %:nombre% ")
	public List<SuperHeroe> buscarNombreContenido(String nombre);
}
