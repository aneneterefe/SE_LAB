package com.eRegistrar.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eRegistrar.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByStudentNumber(String studentNumber);
	
	
	
}
