package com.capstone.capstonecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CapstoneCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneCartApplication.class, args);
	}

}
