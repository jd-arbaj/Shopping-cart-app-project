package com.shopping.cart.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopping.cart.app.controller.AdminController;

@SpringBootApplication
public class ShoppingCartAppApplication implements CommandLineRunner {

	@Autowired
	private AdminController adminController;
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		adminController.run();
	}
	
}
