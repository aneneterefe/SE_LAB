package com.eRegistrar.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value= {"/eregistrar/student/list","/student/list"})
    public ModelAndView listBooks() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.findAll();
        modelAndView.addObject("students", students);
        modelAndView.addObject("studentCount", students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }
	
	@GetMapping(value = {"/eregistrar/student/addNewStudent","/student/addNewStudent"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/add";
    }
	
	@PostMapping(value = {"/eregistrar/student/newStudent","/student/newStudent"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/add";
        }
        student = studentService.save(student);
        return "redirect:/eregistrar/student/list";
    }
	
	@GetMapping(value = {"/eregistrar/student/edit/{studentId}","/student/edit/{studentId}"})
	public String editBook(@PathVariable Long studentId, Model model) {
        Student student = studentService.findById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/list";
    }
	
	@PostMapping(value = {"/eregistrar/student/editStudent","/student/editStudent"})
    public String editStudent(@Valid @ModelAttribute("student") Student student,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.save(student);
        return "redirect:/eregistrar/student/list";
    }
	
	@GetMapping(value = {"/eregistrar/student/delete/{studentId}","/student/edit/{studentId}"})
	public String deleteBook(@PathVariable Long studentId, Model model) {
        studentService.delete(studentId);
        return "redirect:/eregistrar/student/list";
    }
	
	@GetMapping(value = {"/eregistrar/student/search", "/student/search"})
    public ModelAndView searchBooks(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }
}
