package com.theironyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SimpleproductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleproductApplication.class, args);
	}
}
