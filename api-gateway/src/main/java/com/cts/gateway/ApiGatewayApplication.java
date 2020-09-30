package com.cts.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.cts.gateway.exception.CustomErrorDecoder;
import com.google.common.base.Predicate;

import feign.codec.ErrorDecoder;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Arkaprabha
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class ApiGatewayApplication {

	/**
	 * Application runner
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return new CustomErrorDecoder();
	}

	@Bean
	public Docket swaggerConfiguration() {
		/*
		 * return new Docket(DocumentationType.SWAGGER_2).select()
		 * .apis(RequestHandlerSelectors.basePackage("com.cts")).build();
		 */

		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(myPaths()).build();
	}

	private Predicate<String> myPaths() {
		return PathSelectors.regex("/api/.*");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Truyum 2 API").description("Truyum API documentation")
				.termsOfServiceUrl("https://cognizant.com").contact("arkaprabha.chatterjee@cognizant.com").license("Cognizant License")
				.licenseUrl("arkaprabha.chatterjee@cognizant.com").version("1.0").build();
	}
}
