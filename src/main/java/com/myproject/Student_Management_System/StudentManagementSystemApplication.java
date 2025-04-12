package com.myproject.Student_Management_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myproject.Student_Management_System.entity.Student;
import com.myproject.Student_Management_System.repository.StudentRepository;

@SpringBootApplication  //yaha pe use karo " ctrl + shift + t " -> aur search karo mysql to know the dilect 
public class StudentManagementSystemApplication implements CommandLineRunner 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	    System.out.println("Hello world...!");
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception 
	{
	  	Student student1 = new Student("Tushar", "Hajare", "tusharhajare7768@gmail.com");
	  	studentRepository.save(student1);
	  	
	  	Student student2 = new Student("Manish", "Hajare", "manishhajare7768@gmail.com");
	  	studentRepository.save(student2);
	  	
	  	Student student3 = new Student("Sambhaji", "Hajare", "sambhajihajare7768@gmail.com");
	  	studentRepository.save(student3);
	  	
	  	Student student4 = new Student("Prakash", "Hajare", "prakashhajare7768@gmail.com");
	  	studentRepository.save(student4);
	  	
	}
}
