package com.example.demo3;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {
    
	@Autowired
	private StudentRepository  studentRepository;
	public List<Student> retriveAllStudent(){
		return studentRepository.findAll();
	}
	public Optional<Student> retriveStudentById(@PathVariable Long id) {
		return studentRepository.findById(id);
	}
	public void removeStudentById(@PathVariable Long id) {
		studentRepository.deleteById(id);
	}
	@Cacheable("abc")
	public Optional<Student> retriveStudentByName(@PathVariable String name) {
		System.out.println("Inside retriveStudentByName");
		return studentRepository.findByName(name);
	}
	
	public Student insert( Student studentReq) {
		return studentRepository.save(studentReq);
		
	}

	
	public Student update(Student student) {
		return studentRepository.findById(student.getId()).get();
		
	}
}
