package com.project.nongnong.controller;

//

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


// @RestController // controller 에 responsebody가 추가된 것 그냥 컨트롤러가 아닌 레스트컨트롤러의 주용도는 Json 형태로 객체 데이터를 반환한다. / 동작 과정은 @Controller 과 @ResponseBody 를 붙인것과 완벽히 동일하다.
@RestController
@Log4j2
@RequestMapping("/user")
public class UserController {


    @PostMapping("/join")
    public String join(Model model) throws Exception {
        // 회원 가입 요청
        // /main/join 경로에 post방식으로 json데이터를 받고 응답한다 (회원가입 성공)
        // Model 이 Json 타입의 데이터를 담는 곳인지?
        // 서비스 쪽으로 보낸다


        return "join OK!";
    }

    @PostMapping("/login")
    public String login(Model model) {
        // 로그인 요청 받는부분

        return "login OK!";
    }

    @GetMapping("/myPage")
    public Model myPage(Model model) {


        // DB에 처리 요청
        // 서비스 패키지에 만든 클래스를 호출해서 데이터를 받아오는게 맞는지?

        // 결과값 받기
        // 결과값이 모델에 담아진다
        model.addAttribute("user", "list");
        // 회원정보 리턴

        return model;
        // 컨트롤러에서 우선 매핑한 url을 똑같은 구조로 resources의 templates에다 구조를 만들어줘야한다.
        // return 뒤에 오는 url은 html을 불러오겠다는 얘기고
        // @GetMapping과 클래스 처음에있는 @RequestMapping의 매핑은 합쳐서 /user/myPage 고 이는 내가 웹브라우저에 검색할때 적어야하는 url이다 라고 이해하면 된다.
        // @Controller은 이와같이 동작하고 이제는 Json형태의 값을 전달하기 위한 @RestController을 쓸것이다.
        // @RestController은  일반적으로 매핑해봣자 해당 html을 불러오지않고 정확하게 바디를 만들어서 담아야 된다
        // 결론적으로는 타임리프를 쓰기위한 컨트롤러는 @Controller 을 사용하고 Json형태의 데이터를 보낼려면 @RestController을 사용하면 되는것이다.


    }




    // 회원 가입, 탈퇴, 수정, 마이페이지에서 현재 회원정보 요청
    // 각 request 마다 하나씩 매핑해서 여기에 만들어 두면 되는건지?
    // mapper에는 어떤게 들어가야 하는건지

    @GetMapping("/deleteUser")
    public String deleteUser() {

        return "delete OK!";
    }



}