package com.fsap.demo.service;

import java.util.List;

import com.fsap.demo.model.Faculty;
import com.fsap.demo.model.Student;

public interface FacultyService {
	public abstract Faculty saveFaculty(Faculty faculty);
	public abstract List<Faculty> getAllFaculty();
}
