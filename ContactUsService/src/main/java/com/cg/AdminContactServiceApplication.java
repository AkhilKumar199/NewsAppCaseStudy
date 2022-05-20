// Importing package in this code module
package com.cg;
//Importing required classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//Annotation
@SpringBootApplication
@EnableEurekaClient

//Main class
public class AdminContactServiceApplication {
	
	 // Main driver method

	public static void main(String[] args) {
		SpringApplication.run(AdminContactServiceApplication.class, args);
	}

}
