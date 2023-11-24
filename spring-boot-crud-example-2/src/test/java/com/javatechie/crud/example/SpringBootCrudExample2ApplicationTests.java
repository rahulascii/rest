package com.javatechie.crud.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.crud.example.entity.Student;

@SpringBootTest
class SpringBootCrudExample2ApplicationTests {
	
	@Autowired
	private MockMvc mockmvc;
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper om=new ObjectMapper();
	
	@BeforeEach
	private void setup() {
		mockmvc=MockMvcBuilders.webAppContextSetup(context).build();
		
		
	}
	
	@Test
	public void addStudentTest() throws JsonProcessingException {
		 Student stu=new Student();
		stu.setName("Rahul");
		stu.setAddress("Ranchi");
		stu.setMbNo("8404946888");
		stu.setAge(26);
		stu.setEmail("rk@gmail.com");
		String jsonreq=om.writeValueAsString(stu);
		MvcResult result=mockmvc.perform(
				post("/student/add").content(jsonreq).
				content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		
	}
	
}
