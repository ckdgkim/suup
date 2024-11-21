package com.example.spring_sample.student.controller;

import com.example.spring_sample.student.domain.Student;
import com.example.spring_sample.student.repository.StudentRepository;
import com.example.spring_sample.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        Student student1 = service.updateStudent(id, student);
        return student1;
    }

   @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        service.deleteStudent(id);
    }
}
