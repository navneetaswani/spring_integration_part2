package com.example.demo6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo6Application {

	private static final Logger logger=LoggerFactory.getLogger(Demo6Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Demo6Application.class, args);
		logger.info("this is info message");
		logger.warn("this is warning message");
		logger.error("this is error message");
	}

}
