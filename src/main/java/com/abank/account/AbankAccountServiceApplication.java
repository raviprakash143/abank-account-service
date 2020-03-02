package com.abank.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AbankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbankAccountServiceApplication.class, args);
	}

}
