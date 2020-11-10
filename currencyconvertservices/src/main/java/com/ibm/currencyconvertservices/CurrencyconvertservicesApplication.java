package com.ibm.currencyconvertservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CurrencyconvertservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyconvertservicesApplication.class, args);
	}

}
