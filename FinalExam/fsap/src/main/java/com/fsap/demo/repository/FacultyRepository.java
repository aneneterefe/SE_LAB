package com.fsap.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsap.demo.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer>{
	
}
