package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.model.TextEditor;

@SpringBootApplication(scanBasePackages={"com.example.model"})
public class DemoApplication {
	public static void main(String[] args) {
	  ApplicationContext context=SpringApplication.run(DemoApplication.class, args);
	  TextEditor editor=(TextEditor) context.getBean("textEditor");
	  editor.spellCheck();
	}
}
