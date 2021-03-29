package com.example.superheroe.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.superheroe.error.SuperHeroeNotFoundException;
import com.example.superheroe.modelo.SuperHeroe;
import com.example.superheroe.servicios.ServicioSuperHeroe;

@RestController
public class SuperHeroeControlador {

	@Autowired
	private ServicioSuperHeroe servicioSuperHeroe;

	/**
	 * Obtener todos
	 * 
	 * @return
	 */
	@GetMapping("/superheroe")
	public ResponseEntity<?> obtenerTodos() {
		List<SuperHeroe> result = this.servicioSuperHeroe.findAll();

		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(result);
		}

	}

	/**
	 * Obtener por id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/superheroe/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
		SuperHeroe sh = null;

		try {
			sh = this.servicioSuperHeroe.findById(id);
		} catch (SuperHeroeNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.ok(sh);
	}

	/**
	 * Obtener por nombre contenido
	 * 
	 * @param nombre
	 * @return
	 */
	@GetMapping("/superheroe/nombre/{nombre}")
	public ResponseEntity<?> obternerPorNombre(@PathVariable String nombre) {
		List<SuperHeroe> result = null;
		;
		try {
			result = this.servicioSuperHeroe.findByName(nombre);
		} catch (SuperHeroeNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.ok(result);
	}

	/**
	 * Editar superhéroe
	 * @param superheroe
	 * @return
	 */
	@PutMapping("superheroe/{id}")
	public ResponseEntity<?> editar(@RequestBody SuperHeroe superheroe) {
		SuperHeroe sh = null;
		try {
			this.servicioSuperHeroe.modificar(superheroe);
		} catch (SuperHeroeNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

		return ResponseEntity.ok(sh);
	}

	/**
	 * Borrar superhéroe
	 * @param id
	 * @return
	 */
	@DeleteMapping("superheroe/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {

		try {
			this.servicioSuperHeroe.delete(id);
		} catch (SuperHeroeNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.noContent().build();
	}
}
