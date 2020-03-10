package com.eRegistrar.demo.service;

import java.util.List;

import com.eRegistrar.demo.model.Student;

public interface StudentService {

	List<Student> findAll();
	Student findById(Long id);
	Student save(Student student);
	void delete(Long id);
	List<Student> searchStudents(String searchString);
}
