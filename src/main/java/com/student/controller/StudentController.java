
package com.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.entity.Student;
import com.student.service.StudentService;


@Controller
public class StudentController {
	private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
    
    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("students",
                service.getAllStudents());

        model.addAttribute("student",
                new Student());

        return "index";
    }

    @PostMapping("/save")
    public String saveStudent(
            @ModelAttribute Student student) {

        service.saveStudent(student);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(
            @PathVariable Long id) {

        service.deleteStudent(id);

        return "redirect:/";
    }
}
