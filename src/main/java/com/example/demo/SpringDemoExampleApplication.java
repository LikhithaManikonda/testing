package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringDemoExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoExampleApplication.class, args);
	}

}
