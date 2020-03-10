package com.eRegistrar.demo.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eRegistrar.demo.model.Student;
import com.eRegistrar.demo.repository.StudentRepository;
import com.eRegistrar.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	
	private StudentRepository studentRepository;
	
	@Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Car with id : " + id+" is not available"));
	}

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> searchStudents(String searchString) {
		
		return studentRepository.findByStudentNumber(searchString);
	}
	
}
