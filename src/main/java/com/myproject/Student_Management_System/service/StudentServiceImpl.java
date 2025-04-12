package com.myproject.Student_Management_System.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.myproject.Student_Management_System.entity.Student;
import com.myproject.Student_Management_System.impl.StudentImpl;
import com.myproject.Student_Management_System.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentImpl
{
    private StudentRepository studentRepository;
    
    public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents()
	{
	return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student)
	{
		return studentRepository.save(student);
	}

	@Override
	public Student getById(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

}
