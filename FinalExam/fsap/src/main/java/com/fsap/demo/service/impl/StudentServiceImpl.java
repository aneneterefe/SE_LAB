package com.fsap.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.fsap.demo.model.Student;
import com.fsap.demo.repository.StudentRepository;
import com.fsap.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		// TODO Auto-generated constructor stub
		this.studentRepository=studentRepository;
	}
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll(Sort.by(Order.asc("fullName")));
	}

}
