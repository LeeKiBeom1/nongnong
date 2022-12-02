package com.project.nongnong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // BaseEntity의 Auditing 활성화를위해 @EnableJpaAuditing 추가함
@SpringBootApplication
public class NongnongApplication {

    public static void main(String[] args) {
        SpringApplication.run(NongnongApplication.class, args);
    }

}
