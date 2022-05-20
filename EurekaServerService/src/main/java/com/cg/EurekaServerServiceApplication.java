// Importing package in this code module
package com.cg;
//Importing required classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//Annotation
@SpringBootApplication
@EnableEurekaServer
//Main class
public class EurekaServerServiceApplication {
	
	// Main driver method

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerServiceApplication.class, args);
	}

}
