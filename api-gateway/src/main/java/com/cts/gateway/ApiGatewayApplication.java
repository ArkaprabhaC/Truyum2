package com.cts.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.cts.gateway.exception.CustomErrorDecoder;

import feign.codec.ErrorDecoder;

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

	@Bean
	public ErrorDecoder errorDecoder() {
		return new CustomErrorDecoder();
	}
}
