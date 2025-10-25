package com.intexbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication
public class IntexBoxApplication extends SpringServletContainerInitializer {

	public static void main(String[] args) {
		SpringApplication.run(IntexBoxApplication.class, args);
	}

}
