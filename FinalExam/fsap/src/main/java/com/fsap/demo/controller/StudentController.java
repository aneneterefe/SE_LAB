package com.fsap.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fsap.demo.model.Faculty;
import com.fsap.demo.model.Student;
import com.fsap.demo.service.FacultyService;
import com.fsap.demo.service.StudentService;


@Controller
@RequestMapping(value = {"/fsap/student"})
public class StudentController {

	private StudentService studentService;
	private FacultyService facultyService;
	
	@Autowired
	public StudentController(StudentService studentService, FacultyService facultyService) {
		// TODO Auto-generated constructor stub
		this.facultyService=facultyService;
		this.studentService=studentService;
	}
	
	@GetMapping(value = {"/list"})
    public ModelAndView listStudents() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getAllStudents();
        modelAndView.addObject("students", students);
        modelAndView.addObject("studentSize",students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }
	
	@GetMapping(value = {"/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        List<Faculty> faculty=facultyService.getAllFaculty();
        model.addAttribute("faculty",faculty);
        return "student/new";
    }
	
	@PostMapping(value = {"/new"})
    public String addNewStudent(@Valid @ModelAttribute("student")Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("student", student);
            List<Faculty> faculty=facultyService.getAllFaculty();
            model.addAttribute("faculty",faculty);
            return "student/new";
        }
        studentService.saveStudent(student);
        return "redirect:/fsap/student/list";
    }
	
}
