package com.project.nongnong.repository;


import com.project.nongnong.domain.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // 상속만 받으면 모든작업이 끝난다.
    // 엔티티클래스, @Id의 타입을 지정

    // 로그인을 위한 유저 아이디 찾기
    UserEntity findByUseremail(String useremail);
    UserEntity findByUserkey(Long userkey);



}
