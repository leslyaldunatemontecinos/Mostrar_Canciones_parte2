package com.musica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.lam.demo", "com.musica"})
public class MostrarCancionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MostrarCancionesApplication.class, args);
	}

}
