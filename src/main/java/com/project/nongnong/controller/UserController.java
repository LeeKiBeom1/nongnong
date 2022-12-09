package com.project.nongnong.controller;

//

import com.project.nongnong.domain.UserEntity;
import com.project.nongnong.dto.UserDTO;
import com.project.nongnong.dto.UserResponseDTO;
import com.project.nongnong.repository.UserRepository;
import com.project.nongnong.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


// @RestController // controller 에 responsebody가 추가된 것 그냥 컨트롤러가 아닌 레스트컨트롤러의 주용도는 Json 형태로 객체 데이터를 반환한다. / 동작 과정은 @Controller 과 @ResponseBody 를 붙인것과 완벽히 동일하다.
@RestController
@Log4j2
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping
    public String home(Principal principal) {
        return "Hello, " + principal.getName();
    }



    @PostMapping("/api/user/join")
    public Long save(@RequestBody UserDTO userDTO) throws Exception {

        /*
        사용자의 요청을 DTO로 받아서 회원 가입 서비스로 전달하기
         */
        return userService.save(userDTO);

    }

    @PostMapping("/api/user/login")
    public Long login(@RequestBody UserDTO userDTO) {
        // 로그인 요청 받는부분


        return userService.login(userDTO);
    }

    @GetMapping("/api/user/list")
    public List<UserEntity> myPage() {

        List<UserEntity> userEntity = userRepository.findAll();

        // 서비스로 보내고 키값을 받아 조회하고 결과값을 담고 리턴해줄것

        return userEntity;


    }


    // 회원 가입, 탈퇴, 수정, 마이페이지에서 현재 회원정보 요청
    // 각 request 마다 하나씩 매핑해서 여기에 만들어 두면 되는건지?
    // mapper에는 어떤게 들어가야 하는건지

    @GetMapping("/api/user/delete")
    public String deleteUser() {

        userRepository.deleteAll();

        return "모든 유저 삭제 완료";
    }



}
