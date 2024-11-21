//package com.example.spring_sample.student.service;
//
//import com.example.spring_sample.student.domain.Student;
//import com.example.spring_sample.student.repository.StudentRepository;
//import com.example.spring_sample.student.repository.StudentRepositoryMapImpl;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class StudentServiceTest {
//    StudentRepository sr = new StudentRepositoryMapImpl();
//    StudentService service = new StudentService(sr);
//
//
//    @Test
//    void getAllStudents() {
//        //given
//        //when
//        List<Student> allStudents = service.getAllStudents();
//        //then
//        Assertions.assertThat(allStudents.size()).isEqualTo(1);
//    }
//}