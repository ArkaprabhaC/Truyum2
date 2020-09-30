package com.cts.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * @author Arkaprabha
 *
 */
@SpringBootApplication
@EnableFeignClients
public class ApiGatewayApplication {
	
	
	/**
	 * Application runner
	 * @param args
	 */
	public static void main(final String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
