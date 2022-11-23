package com.project.nongnong.user;

import com.project.nongnong.entity.UserEntity;
import com.project.nongnong.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;


@SpringBootTest
public class TestUserCRUD {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void insertTest() throws Exception {
        IntStream.rangeClosed(1,3).forEach(i -> {
            UserEntity userEntity = UserEntity.builder()
                    .user_email("testEmail" + i)
                    .user_pwd("testPwd" + i)
                    .user_nickname("testNickname" + i)
                    .build();
            userRepository.save(userEntity);
        });

    }

    @Test
    public void selectTest() throws Exception {
        Long user_key = 2L;
    }


}
