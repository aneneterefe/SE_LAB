package com.fsap.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsap.demo.model.Faculty;
import com.fsap.demo.repository.FacultyRepository;
import com.fsap.demo.service.FacultyService;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
@Service
public class FacultyServiceImpl implements FacultyService {

	private FacultyRepository facultyRepository;
	
	@Autowired
	public FacultyServiceImpl(FacultyRepository facultyRepository) {
		// TODO Auto-generated constructor stub
		this.facultyRepository=facultyRepository;
	}
	
	@Override
	public List<Faculty> getAllFaculty() {
		// TODO Auto-generated method stub
		
		return facultyRepository.findAll(Sort.by(Order.desc("fullName")));
	}

	@Override
	public Faculty saveFaculty(Faculty faculty) {
		// TODO Auto-generated method stub
		return facultyRepository.save(faculty);
	}

	
}
