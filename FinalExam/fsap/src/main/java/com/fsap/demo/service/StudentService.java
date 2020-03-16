package com.fsap.demo.service;

import java.util.List;

import com.fsap.demo.model.Student;


public interface StudentService {

	 public abstract Student saveStudent(Student student);
	 public abstract List<Student> getAllStudents();
}
