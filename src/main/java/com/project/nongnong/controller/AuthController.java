package com.project.nongnong.controller;


import com.project.nongnong.service.TokenService;
import com.sun.net.httpserver.HttpContext;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class AuthController {

    private final TokenService tokenService;



    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/api/user/token")
    public String token(Authentication authentication) {
        // 들어온 아이디와 비밀번호를 인코딩후 디비에 있는지 확인하기




        String token = tokenService.generateToken(authentication);
        return token;
    }
}
