package com.example.spring_swagger.userdomain.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class UserLoginDto {
    private String userId;
    private String password;
}
