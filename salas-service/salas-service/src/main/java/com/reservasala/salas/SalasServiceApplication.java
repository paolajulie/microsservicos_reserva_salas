package com.reservasala.salas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SalasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalasServiceApplication.class, args);
	}

}
