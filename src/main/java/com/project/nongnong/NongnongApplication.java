package com.project.nongnong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // jpa를 사용하기위해 추가한 어노테이션 b01참고
@SpringBootApplication
public class NongnongApplication {

    public static void main(String[] args) {
        SpringApplication.run(NongnongApplication.class, args);
    }

}
