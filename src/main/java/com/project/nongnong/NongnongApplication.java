package com.project.nongnong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NongnongApplication {

    public static void main(String[] args) {
        SpringApplication.run(NongnongApplication.class, args);
    }

}
