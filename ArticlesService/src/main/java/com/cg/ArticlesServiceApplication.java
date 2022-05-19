// Importing package in this code module
package com.cg;

//Importing required classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//Annotation
@SpringBootApplication
@EnableEurekaClient

//Main class
public class ArticlesServiceApplication {
	
	// Main driver method

	public static void main(String[] args) {
		SpringApplication.run(ArticlesServiceApplication.class, args);
	}

}
