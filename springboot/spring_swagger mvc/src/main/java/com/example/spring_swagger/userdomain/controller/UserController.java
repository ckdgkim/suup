package com.example.spring_swagger.userdomain.controller;

import com.example.spring_swagger.userdomain.domain.User;
import com.example.spring_swagger.userdomain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
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
        return userService.getOneUser(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        userService.removeUser(userId);
    }

    @PatchMapping("/{userId}")
    public User updatePassword(@PathVariable("userId") String userId, @RequestBody User user) {
        return userService.updatePassword(userId, user.getPassword());
    }

}
