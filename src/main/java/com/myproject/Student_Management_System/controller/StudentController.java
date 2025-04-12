package com.myproject.Student_Management_System.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.myproject.Student_Management_System.entity.Student;
import com.myproject.Student_Management_System.service.StudentServiceImpl;

@Controller
public class StudentController 
{
	private StudentServiceImpl impl;
	
	public StudentController(StudentServiceImpl impl) {
		super();
		this.impl = impl;
	}

	  //handler method to handle list of students return model and view
	  @GetMapping("/students")
	  public String getAllData(Model model)
	  {
			model.addAttribute("students", impl.getAllStudents());
		  return "students"; //view page -> html page -> students.html
	  }
	
	@GetMapping("/students/new")
	public String createStudentsForm(Model model)
	{
		//create student object to hold the student form of data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudents(@ModelAttribute("student") Student student)
	{
		impl.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String updateStudentForm(@PathVariable int id, Model model) {
	
		model.addAttribute("student", impl.getById(id));
		return "edit_student"; 
		}
	
	//handler method
    @PostMapping("/students/{id}")
	public String updateDataById(@PathVariable int id, @ModelAttribute("student") Student student, Model model) 
	{
		//get the students from database by id
		Student existingStudent = impl.getById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		//save updated student object
		impl.updateStudent(existingStudent);
		return "redirect:/students";
	}

	//handler method
    @GetMapping("/students/{id}")
	public String deleteStudentById(@PathVariable int id) {
		impl.deleteStudent(id);
		return "redirect:/students";
	}
}
