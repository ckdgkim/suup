package com.example.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//RequestMapping("/students")
public class StudentController {
  @GetMapping
  public String getAllStudents() {
    return "getAllStudents";
  }

  @PostMapping
  public void createStudent() {
//    return "createStudent successfully";
  }

}
