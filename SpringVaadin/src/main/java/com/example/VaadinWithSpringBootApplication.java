package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:springConfig.xml")
public class VaadinWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaadinWithSpringBootApplication.class, args);
	}
}
