package com.nadeem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nadeem.model.Student;
import com.nadeem.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studeService;

	@GetMapping("/")
	public String defaultMapping(Model model) {
		model.addAttribute("student", new Student());
		return "index";
	}
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute Student student, Model model) {
		studeService.saveStudent(student);
		model.addAttribute("message","Student Saved Sucessfully.");
		model.addAttribute("student", new Student());
		return "index";
	}
	
	@GetMapping("/students")
	public String getStudentList(Model model) {
	    List<Student> student =	studeService.finAll();
	    model.addAttribute("students",student);
		return "students";
	}
	
	@GetMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable("id") long id) {
		studeService.findById(id);
		return "redirect:/students";
	}
	@GetMapping("/student/{id}")
	public String updateStudent(@PathVariable("id") long id, Model model) {
		Student existingStudent = studeService.findById(id);
		model.addAttribute("student",existingStudent);
		return "index";
	}
	
}
