//package com.project.nongnong.config;
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Log4j2
//@Configuration
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.csrf().disable();
//
//        log.info("-------------configure---------------");
//        http.formLogin();
//        return http.build();
//
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        log.info("-----------config----------");
//        return (web -> web.ignoring().antMatchers(HttpMethod.POST, "/signUp"));
//    }
//
//
//}


/*
로그레벨을 통해서 필터링을 해서 권한을 줄 수 있다.

스프링 시큐리티가 하는 역할은 크게 인증과 인가 로 나눌수 있다.

인증은 로그인 인가는 로그인한 사용자라도 자원에 접근을 할 수 있는지 권한을 확인한다.

로그인을통해 인증을 수행하고 시큐리티 설정으로 특정권한이 있는 사용자들만 접근할수 있도록 설정하여 필터링 한다.


구현하는 순서

1. 인증제공자


 */