package com.example.superheroe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SuperheroeApplication {
	/**
	 * Hola, este es el main!
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SuperheroeApplication.class, args);
	}

}
