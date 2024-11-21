package com.example.spring_swagger.Logindomain.controller;

import com.example.spring_swagger.Logindomain.service.LoginService;
import com.example.spring_swagger.userdomain.domain.User;
import com.example.spring_swagger.userdomain.dto.UserLoginDto;
import com.example.spring_swagger.userdomain.service.UserService;
import com.example.spring_swagger.userdomain.session.SessionConst;
import com.example.spring_swagger.userdomain.session.UserSession;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//@Controller
//@Slf4j
//@RequiredArgsConstructor
//public class LoginController {
//    private final LoginService loginService;
//    private final UserService userService;
//
//    @GetMapping("/register")
//    public String register(HttpServletRequest req) {
////        log.info("register ==> {}", req.getRequestURI());
//        return "회원가입 완료";
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "login/login";
//    }
//
////    @PostMapping("/login")
////    public String login(@ModelAttribute UserLoginDto userLoginDto,@RequestParam(required = true, defaultValue = "/") String redirectUri, HttpServletRequest req, HttpServletResponse res) {
////        User login = loginService.login(userLoginDto);
////        if (login == null){
////            return "redirect:/login";
////        }
////        UserSession userSession = new UserSession();
////        userSession.setUserId(login.getUserId());
////        userSession.setUserName(login.getUserName());
////
////        HttpSession session = req.getSession(true);
////        session.setAttribute(SessionConst.SESSION_NAME, userSession);
////
////        Cookie cookie = new Cookie(SessionConst.COOKIE_NAME, SessionConst.SESSION_NAME);
////        cookie.setPath("/");
////        cookie.setMaxAge(600); // 600초 = 10분
////        res.addCookie(cookie);
////
////        return "redirect:" + redirectUri; //login ==> /posts , parameter 로 redirectURI 가지고 온 경우에는
////    }
//
//
//    @PostMapping("/login")
//    public String login(HttpServletRequest req, HttpServletResponse resp, @RequestBody User user) {
////        log.info("login ==> {}", req.getRequestURI());
//        boolean isLogin = loginService.isLoginSuccess(user);
//        if (isLogin) {
//            HttpSession session = req.getSession(true);
//            String uuid = UUID.randomUUID().toString();
//            session.setAttribute("session_id", uuid);
//            session.setAttribute("userId", user.getUserId());
//            session.setMaxInactiveInterval(60*2);
//            Cookie cookie = new Cookie("session_id", uuid);
//            resp.addCookie(cookie);
//            return "로그인 성공";
//        }
//        return "로그인 실패";
////        return session.getAttribute("userId") + " : 로그인 완료";
//    }
//
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest req, HttpServletResponse resp) {
////        log.info("logout ==> {}", req.getRequestURI());
//        HttpSession session = req.getSession(false);
//        if (session != null) {
//            session.invalidate();
//        }
//        Cookie cookie = new Cookie(SessionConst.COOKIE_NAME, null);
//        cookie.setMaxAge(0);
//        resp.addCookie(cookie);
//        return "redirect:/login";
//    }
//}

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginDto userLoginDto,
                        @RequestParam(name="redirectURI", required = true, defaultValue = "/posts") String redirectURI,
                        HttpServletRequest req,
                        HttpServletResponse res){

        log.info("redirect uri: {}", redirectURI);
        User loginUser = loginService.login(userLoginDto);
        log.info("loginUser: {}", loginUser);
        if(loginUser == null){
            return "redirect:/login";
        }
        // 로그인 성공 : 세션 생성
        UserSession userSession = new UserSession();
        userSession.setUserId(loginUser.getUserId());
        userSession.setUserName(loginUser.getUserName());

        HttpSession session = req.getSession(true);// 없으면 생성
        session.setAttribute(SessionConst.SESSION_NAME, userSession);

        // 로그인 성공한 세션 정보를 쿠키에 보내기
        Cookie cookie = new Cookie(SessionConst.COOKIE_NAME, SessionConst.SESSION_NAME);
        cookie.setPath("/");
        cookie.setMaxAge(600); // 600초 = 10분
        res.addCookie(cookie);

        return "redirect:" + redirectURI;        // login ==> /posts , parameter 로 redirectURI 가지고 온 경우에는
    }


}