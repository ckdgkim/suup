package com.example.spring_swagger.userdomain.controller;

import com.example.spring_swagger.userdomain.domain.User;
import com.example.spring_swagger.userdomain.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

//    @GetMapping("/{id}")
//    public User getUser(@PathVariable("id") Integer id) {
//        return userService.getOneUser(id);
//    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        //세션 정보를 얻어온다. ==> 로그인 된 상태인지 확인 ==> 본인이 맞는지 확인해서 본인의 정보만 조회해야 한다.
        return userService.getOneUser(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        //세션 정보를 얻어온다. ==> 로그인 된 상태인지 확인 ==> 본인이 맞는지 확인해서 본인인 경우에만 탈퇴해야 한다.
        userService.removeUser(userId);
    }

    @PatchMapping("/{userId}")
    public User updatePassword(@PathVariable("userId") String userId, @RequestBody User user) {
        //세션 정보를 얻어온다. ==> 로그인 된 상태인지 확인 ==> 본인이 맞는지 확인해서 보인인 경우에만 수정해야 한다.
        return userService.updatePassword(userId, user.getPassword());
    }

}
