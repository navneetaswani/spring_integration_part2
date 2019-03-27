package com.example.demo5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource(value={"app.properties"})
public class DemoApplication {
		
	public static void main(String[] args) {
	  ApplicationContext context=SpringApplication.run(DemoApplication.class, args);
	 
	}
	
}
