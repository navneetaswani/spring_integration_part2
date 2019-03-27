package com.example.demo3;

import java.util.Arrays;

import org.hibernate.event.internal.AbstractSaveEventListener.EntityState;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends Exception {

	public StudentNotFoundException(String msg) {
		super(msg);
	}

}
