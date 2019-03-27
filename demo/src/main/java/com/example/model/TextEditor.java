package com.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {

	@Autowired
	private SpellChacker spellChacker;
	
	public void spellCheck(){
		System.out.println("Inside spell check method");
		spellChacker.m1();
	}
}
