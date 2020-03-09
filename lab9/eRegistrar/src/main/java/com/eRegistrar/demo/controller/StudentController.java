package com.eRegistrar.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eRegistrar.demo.model.Student;
import com.eRegistrar.demo.service.StudentService;


@Controller
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService=studentService;
	}
	
	@GetMapping(value="/student/list")
    public ModelAndView listBooks() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.findAll();
        modelAndView.addObject("students", students);
        modelAndView.addObject("studentCount", students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }


}
