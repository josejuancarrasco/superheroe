package com.example.superheroe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.superheroe.servicios.ServicioSuperHeroe;

@SpringBootTest
class SuperheroeApplicationTests {
	
	@Autowired
	ServicioSuperHeroe servicio;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void test() {
		assertThat(this.servicio.findAll()).hasSize(4);
	}

}
