package com.example.superheroe.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class SuperHeroe {
	
	@Id
	@GeneratedValue
	private Long id;

	private String nombre;
	
	public SuperHeroe(String nombre) {
		this.nombre = nombre;
	}

}
