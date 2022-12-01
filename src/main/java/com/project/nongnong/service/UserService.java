package com.project.nongnong.service;


import com.project.nongnong.domain.UserEntity;
import com.project.nongnong.dto.UserDTO;
import com.project.nongnong.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Log4j2
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserDTO userDTO) {
        // DTO의 엔티티 변환메소드를 통해 엔티티클래스에 저장
        UserEntity userEntity = userDTO.toEntity();
        // 레포지토리를 이용해 디비와 연결해 저장
        userRepository.save(userEntity);

        // log
        log.info(userEntity.getUserkey());

        // 유저의 키값을 리턴해 프론트가 사용할수 있게 만듬
        return userEntity.getUserkey();

    }

    @Transactional
    public Long login(UserDTO userDTO) {
        Long result = null;




        return result;
    }

}
