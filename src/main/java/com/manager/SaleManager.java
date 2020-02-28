package com.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class SaleManager {

	public static void main(String[] args) {
		
		System.out.println("Sales Manager");
		
		SpringApplication.run(SaleManager.class, args);

	}
	
	

}
