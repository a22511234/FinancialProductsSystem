package com.example.FinancialProductSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="Financial product preference recording system",
				version="1.0.0",
				description="新進人員 玉山銀行後端工程師 Java 實作題",
				contact=@Contact(
						name="Howard Huang",
						email="a22511234@gmail.com")
				)
		
		)
public class FinancialProductsSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialProductsSystemApplication.class, args);
	}

}
