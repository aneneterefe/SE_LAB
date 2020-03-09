package com.eRegistrar.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eRegistrar.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
