package com.project.nongnong.service;


import org.springframework.ui.Model;

// UserService 인터페이스와 Impl 을 따로 두고 사용하는 이유?
public interface UserService {

// Impl에서 사용할 메소드를 인터페이스 형태로 만들어 놓는곳
    // 추상 메소드 이기때문에 추상적인 명명의 메소드를 적고 실제적인 디비와 연동후 데이터를 받아오는 동작을 하는 객체는 UserServiceImpl이 담당 하고 있다.
// 구현하고자 하는 부분이 명확하면서 제한적으로 내용이 드러나는 장점이 있다.

    // 회원 등록 하기
    public void joinUser(Model model);

}
