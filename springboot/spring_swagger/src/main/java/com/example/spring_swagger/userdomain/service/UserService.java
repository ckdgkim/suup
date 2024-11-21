package com.example.spring_swagger.userdomain.service;

import com.example.spring_swagger.userdomain.domain.User;
import com.example.spring_swagger.userdomain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createNewUser(User user) {
        return userRepository.save(user);
    }

//    public User getOneUser(String userId) {
//        User user = userRepository.findById(Integer.valueOf(userId));
//        return user;
//    }

    @Transactional(readOnly = true)
    public User getOneUser(String userId) {
        return userRepository.findByUserId(userId);
    }


    public void removeUser(String userId) {
        User user = userRepository.findByUserId(userId);
        userRepository.deleteById(user.getId());
    }

    public void updateNewPassword(String userId) {
        User user = userRepository.findByUserId(userId);
    }

    public User updatePassword(String userId, String newPassword) {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new RuntimeException("User not found"); // 사용자 없을 경우 예외 처리
        }
        user.setPassword(newPassword); // 비밀번호 업데이트
        log.info("패스워드 변경 성공" + user.getPassword());
        return userRepository.save(user); // 변경된 사용자 정보를 저장
    }

}
