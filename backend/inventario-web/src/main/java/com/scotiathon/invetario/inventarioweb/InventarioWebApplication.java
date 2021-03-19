package com.scotiathon.invetario.inventarioweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.scotiathon.invetario")
public class InventarioWebApplication {

	public static void main(String[] args) {
		String word = "null";
		Integer.parseInt(word);
		SpringApplication.run(InventarioWebApplication.class, args);
	}

}
