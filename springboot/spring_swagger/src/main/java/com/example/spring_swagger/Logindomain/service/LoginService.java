package com.example.spring_swagger.Logindomain.service;

import com.example.spring_swagger.userdomain.domain.User;
import com.example.spring_swagger.userdomain.dto.UserLoginDto;
import com.example.spring_swagger.userdomain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
//@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


//    public User login(UserLoginDto userDto) {
//
//    }
    public boolean isLoginSuccess(UserLoginDto userDto) {
        if (userDto != null &&
                StringUtils.hasText(userDto.getUserId()) &&
                StringUtils.hasText(userDto.getPassword())) {

            // userId로 사용자 정보 조회
            User foundUser = userRepository.findByUserId(userDto.getUserId());

            // 사용자가 존재하고 비밀번호가 일치하는지 확인
            if (foundUser != null && foundUser.getPassword().equals(userDto.getPassword())) {
                return true;
            }
        }
        return false;
    }
}