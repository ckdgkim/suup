package com.example.springsecurity.controller;

import com.example.springsecurity.Dto.AccountLoginDto;
import com.example.springsecurity.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final AccountService accountService;

    @GetMapping("/login")
    public String login() {
        return "basic/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute AccountLoginDto loginDto) {
        System.out.println("islogin 전에 logindto입니다." + loginDto);
        Boolean islogin = accountService.isValidUser(loginDto);
        System.out.println("islogin입니다," + islogin);
        if (islogin) {
            return "redirect:/";
        }
        return "redirect:/login";
    }
}

