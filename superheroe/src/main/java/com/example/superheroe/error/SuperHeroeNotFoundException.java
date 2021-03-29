package com.example.superheroe.error;

public class SuperHeroeNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7522987057913375355L;
	
	/**
	 * Devolver error por id
	 * @param id
	 */
	public SuperHeroeNotFoundException(Long id) {
		super("No se puede encontrar el superhéroe con id: " + id);
	}
	
	/**
	 * Devovler error por nombre
	 * @param nombre
	 */
	public SuperHeroeNotFoundException(String nombre) {
		super("No se han encontrado superhéroes que contengan " + nombre +" en su nombre");
	}

}
