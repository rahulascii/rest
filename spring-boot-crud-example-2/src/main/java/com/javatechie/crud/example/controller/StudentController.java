package com.javatechie.crud.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.crud.example.entity.Student;
import com.javatechie.crud.example.exception.UserNotFoundException;
import com.javatechie.crud.example.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService empservice;

	@PostMapping("/add")
	public ResponseEntity<Student> addEmployee(@RequestBody @Valid Student emp) {
		return new ResponseEntity<>(empservice.addEmployee(emp),HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Student> >getAllEmployees() {
		return new ResponseEntity<>(empservice.getEmployees(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<Student> getEmployeeById(@PathVariable int empId) throws UserNotFoundException {
		return new ResponseEntity<>(empservice.getEmployee(empId),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int empId){
		return new ResponseEntity<>(empservice.deleteEmployee(empId),HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Student> updateEmployee(@RequestBody Student emp) {
		return new ResponseEntity<>(empservice.updateEmployee(emp),HttpStatus.OK);
	}
	
	
}
