package com.ibm.accountopenservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AccountOpenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountOpenServiceApplication.class, args);
	}

	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ibm.accountopenservice")).paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().title("Account Open Service")
						.description("This API is used for customer account opening").version("1.0")
						/*
						 * .license("IBM") .licenseUrl("https://ibm.com") .contact(new
						 * Contact("Anant Agrawal", "https://ibm.com", "anant@in.ibm.com"))
						 */
						.build());
	}
}
