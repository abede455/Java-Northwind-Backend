package com.northwind.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.northwind.api.service.ProductPhotoService;

@SpringBootApplication
public class JavaNorthwindApiApplication implements CommandLineRunner {

	@Autowired
	ProductPhotoService service;

	public static void main(String[] args) {
		SpringApplication.run(JavaNorthwindApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.init();
	}
}
