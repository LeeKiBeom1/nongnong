package com.project.nongnong.repository;


import com.project.nongnong.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // 상속만 받으면 모든작업이 끝난다.
    // 엔티티클래스, @Id의 타입을 지정

}
