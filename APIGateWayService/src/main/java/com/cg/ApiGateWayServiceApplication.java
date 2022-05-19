package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//Annotation
@SpringBootApplication
@EnableEurekaClient
//Main Class
public class ApiGateWayServiceApplication {
	
	//Main Mathod

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayServiceApplication.class, args);
	}

}
