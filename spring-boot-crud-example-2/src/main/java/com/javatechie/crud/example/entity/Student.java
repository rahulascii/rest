package com.javatechie.crud.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	@NotNull (message = "Name cannot be blank")
	private String name;
	@Email (message ="Email cannot be blank")
	private String email;
	@NotNull (message =" Mobile number should be of 10 digit")
	@Pattern(regexp="^\\d{10}$")
	private String mbNo;
	
	@Min(18)
	@Max(60)
	private int age;
	@NotBlank
	private String address;
	

}
