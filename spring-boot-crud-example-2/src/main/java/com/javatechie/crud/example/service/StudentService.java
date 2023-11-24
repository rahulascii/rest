package com.javatechie.crud.example.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Student;
import com.javatechie.crud.example.exception.UserNotFoundException;
import com.javatechie.crud.example.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository emprepo;
	
	public Student addEmployee(Student emp) {
		return emprepo.save(emp);
	}
	
	public Student getEmployee(int empId) throws UserNotFoundException {
		Student st= emprepo.findById(empId).orElse(null);
		if(st!=null) {
			return st;
		}
		else
		{
			throw new UserNotFoundException("User not found with id "+empId);
		}
	}
	
	public List<Student> getEmployees() {
		return emprepo.findAll();
	}
	
	public String deleteEmployee(int empId) {
		Student emp= null;
		String status;
		emp=emprepo.findById(empId).orElse(null);
		System.out.println(emp.toString());
		if(emp==null) {
			status= "No record found";
		}
		else
		{
			emprepo.deleteById(empId);
			status= "Record Deleted";
		}
		return status;
	}
	
	
	public Student updateEmployee(Student ep) {
		Student emp= null;
		emp=emprepo.findById(ep.getId()).orElse(null) ;
		if(emp==null) {
			
		}
		else
		{
		emp=emprepo.save(ep);
			
		}
		return emp;
	
	}
	

}
