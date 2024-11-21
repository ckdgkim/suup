package com.example.spring_sample.student.repository;

import com.example.spring_sample.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryMysqlImpl implements StudentRepository {
    final DataSource dataSource;

    @Autowired
    public StudentRepositoryMysqlImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("univ"),
                        rs.getString("birth"),
                        rs.getString("email")
                );
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace(); // 로깅을 사용하는 것이 좋습니다.
        }
        return students;
    }


    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public int addStudent(Student student) {
        return 0;
    }

    @Override
    public void deleteStudent(int id) {

    }

}
