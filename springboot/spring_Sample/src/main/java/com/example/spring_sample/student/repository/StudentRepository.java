package com.example.spring_sample.student.repository;

import com.example.spring_sample.student.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(int id);
    void updateStudent(Student student);
    int addStudent(Student student);
    void deleteStudent(int id);

}
