package com.example.spring_swagger.userdomain.repository;


import com.example.spring_swagger.userdomain.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(String userId);
}
