package com.myproject.Student_Management_System.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.myproject.Student_Management_System.entity.Student;


public interface StudentImpl 
{
  public List<Student> getAllStudents();
  
  public Student saveStudent(Student student);
  
  public Student getById(int id);
  
  public Student updateStudent(Student student);
  
  public void deleteStudent(int id);
}
