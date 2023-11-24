package com.javatechie.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.crud.example.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	

	

}
