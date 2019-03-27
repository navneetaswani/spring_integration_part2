package com.example.demo4;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@GetMapping("/students/all")
	public List<Student> retriveAllStudent() {
		return repository.findAll();
	}

	@GetMapping("/students/by/{id}")
	public Student retriveStudentById(@PathVariable Long id) {
		
		Optional<Student> optional = repository.findById(id);
		if (!optional.isPresent()) {
			try {
				throw new StudentNotFoundException("Student not found for id=" + id);
			} catch (StudentNotFoundException e) {

			}
		}
		return optional.get();
	}
	
	@GetMapping("/students/byName/{name}")
	public Student retriveStudentByName(@PathVariable String name) {
		Optional<Student> optional = repository.findByName(name);
		if (!optional.isPresent()) {
			try {
				throw new StudentNotFoundException("Student not found for name=" + name);
			} catch (StudentNotFoundException e) {

			}
		}
		return optional.get();
	}

	@DeleteMapping("/students/delete/{id}")
	public void removeStudentById(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@PostMapping("/students/insert")
	public ResponseEntity<Student> insert(@RequestBody Student studentReq) {
		Student student = repository.save(studentReq);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@PatchMapping("/students/update")
	public ResponseEntity<Student> update(@RequestBody Student studentReq) {
		Student student = repository.findById(studentReq.getId()).get();
		student.setName(studentReq.getName());
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

}
