package com.project.nongnong.controller;

// 메인컨트롤러는 모든 요청의 매핑을 이곳에서 관리한다.

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // controller 에 responsebody가 추가된 것 그냥 컨트롤러가 아닌 레스트컨트롤러의 주용도는 Json 형태로 객체 데이터를 반환한다. / 동작 과정은 @Controller 과 @ResponseBody 를 붙인것과 완벽히 동일하다.
@Log4j2
@RequestMapping("/main")
public class UserController {

    @RequestMapping("/join")
    public void join() {
        // /main/join 경로에 post방식으로 json데이터를 받고 응답한다 (회원가입 성공)
    }

    // 회원 가입, 탈퇴, 수정, 마이페이지에서 현재 회원정보 요청
    // 각 request 마다 하나씩 매핑해서 여기에 만들어 두면 되는건지?
    // mapper에는 어떤게 들어가야 하는건지



}
