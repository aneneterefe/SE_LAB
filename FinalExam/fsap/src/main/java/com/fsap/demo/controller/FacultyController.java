package com.fsap.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fsap.demo.model.Faculty;
import com.fsap.demo.service.FacultyService;

@Controller
@RequestMapping(value = {"/fsap/faculty"})
public class FacultyController {

	private FacultyService facultyService;
	
	public FacultyController(FacultyService facultyService) {
		// TODO Auto-generated constructor stub
		this.facultyService=facultyService;
	}
	
	@GetMapping(value = {"/list"})
    public ModelAndView listFaculty() {
        ModelAndView modelAndView = new ModelAndView();
        List<Faculty> faculty = facultyService.getAllFaculty();
        modelAndView.addObject("faculties", faculty);
        modelAndView.addObject("facultySize",faculty.size());
        modelAndView.setViewName("faculty/list");
        return modelAndView;
    }
}
