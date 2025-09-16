package com.angelroquel.AhorcadoPSpring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AhorcadoPSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AhorcadoPSpringApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Api Levantada");
    }
}
