package com.example.superheroe.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.superheroe.error.SuperHeroeNotFoundException;
import com.example.superheroe.modelo.SuperHeroe;
import com.example.superheroe.repositorio.SuperHeroeRepositorio;

@Service
public class ServicioSuperHeroe {

	@Autowired
	private SuperHeroeRepositorio superHeroeRepositorio;

	/**
	 * Listar Todos
	 * 
	 * @return
	 */
	@Cacheable("superheroes")
	public List<SuperHeroe> findAll() {
		return superHeroeRepositorio.findAll();
	}

	/**
	 * Buscar por Id
	 * 
	 * @param id
	 * @return
	 */
	public SuperHeroe findById(Long id) {
		return this.superHeroeRepositorio.findById(id).orElseThrow(() -> new SuperHeroeNotFoundException(id));
	}

	/**
	 * Buscar por nombre contenido
	 * 
	 * @param name
	 * @return
	 */
	public List<SuperHeroe> findByName(String name) {

		if (this.superHeroeRepositorio.buscarNombreContenido(name).isEmpty()) {
			throw new SuperHeroeNotFoundException(name);
		}
		return this.superHeroeRepositorio.buscarNombreContenido(name);
	}

	/**
	 * Editar superhéroe
	 * 
	 * @param Editar superhéroe
	 * @return
	 */
	@CacheEvict(cacheNames = "superheroes")
	public SuperHeroe modificar(SuperHeroe editar) {
		// Se recupera el heroe a editar
		SuperHeroe sh = this.superHeroeRepositorio.findById(editar.getId())
				.orElseThrow(() -> new SuperHeroeNotFoundException(editar.getId()));

		// Se modifica el heroe
		sh.setNombre(editar.getNombre());

		return this.superHeroeRepositorio.save(sh);
	}

	/**
	 * Eliminar SuperHéroe
	 * 
	 * @param id
	 */
	@CacheEvict(cacheNames = "superheroes")
	public void delete(Long id) {

		SuperHeroe sh = this.superHeroeRepositorio.findById(id).orElseThrow(() -> new SuperHeroeNotFoundException(id));
		this.superHeroeRepositorio.delete(sh);
	}

}
