package com.impace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans(value= {@ComponentScan(basePackages="com.impace")})
public class FarmErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmErpApplication.class, args);
	}
}
