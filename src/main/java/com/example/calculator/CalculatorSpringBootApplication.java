package com.example.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class CalculatorSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorSpringBootApplication.class, args);
	}
}
