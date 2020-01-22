package com.negs.springboot.microservice.standard.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.negs.springboot.microservice.standard.calculator" })
public class StandardCalculatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandardCalculatorServiceApplication.class, args);
	}

}
