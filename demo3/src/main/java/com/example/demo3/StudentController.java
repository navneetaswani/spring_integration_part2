package com.example.demo3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
	private StudentService service;

	@GetMapping("/students/all")
	public List<Student> retriveAllStudent() {
		return service.retriveAllStudent();
	}

	
	@GetMapping("/students/by/{id}")
	public Student retriveStudentById(@PathVariable Long id) throws Exception{
		System.out.println("In side retriveStudentById");
		Optional<Student> optional = service.retriveStudentById(id);
		if (!optional.isPresent()) {
			//try {
				throw new StudentNotFoundException("Student not found for id=" + id);
			//} catch (StudentNotFoundException e) {

			//}
		}
		return optional.get();
	}
	
	@GetMapping("/students/byName/{name}")
	public Student retriveStudentByName(@PathVariable String name) throws Exception{
		System.out.println("In side retriveStudentByName");
		Optional<Student> optional = service.retriveStudentByName(name);
		if (!optional.isPresent()) {
			//try {
				throw new StudentNotFoundException("Student not found for name=" + name);
			//} catch (StudentNotFoundException e) {

			//}
		}
		return optional.get();
	}

	@DeleteMapping("/students/delete/{id}")
	public void removeStudentById(@PathVariable Long id) {
		service.removeStudentById(id);
	}

	@PostMapping("/students/insert")
	public ResponseEntity<Student> insert(@RequestBody Student studentReq) {
		Student student = service.insert(studentReq);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@PatchMapping("/students/update")
	public ResponseEntity<Student> update(@RequestBody Student studentReq) {
		Student student = service.update(studentReq);
		student.setName(studentReq.getName());
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

}
