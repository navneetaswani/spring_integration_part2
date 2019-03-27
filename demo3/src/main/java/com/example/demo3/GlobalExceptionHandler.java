package com.example.demo3;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handlerStudentNotFound(StudentNotFoundException studentNotFoundException,WebRequest request){
		ErrorDetails details=new ErrorDetails(new Date(),studentNotFoundException.getMessage(), request.getDescription(false));
	  return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
	}
}
