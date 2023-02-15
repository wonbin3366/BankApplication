package shop.mtcoding.newblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.newblog.dto.user.JoinReqDto;
import shop.mtcoding.newblog.handler.ex.CustomException;
import shop.mtcoding.newblog.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /*
     * post요청과 put요청시에만 body 데이터가 있다.
     * 해당 body 데이터는 컨트롤러 메서드의 매개변수에 주입된다.(DS디스패처서블릿)
     * 스프링은 x-www-urlencoded가 기본 파싱전력
     * key=value&key=value (form 태그의 기본 전송 전략)
     * key = 폼태그의 name을 의미한다
     * 컨트롤러의 메서드는 매개변수에서 두가지 방식으로 데이터를 받음
     * 1. 그냥변수, 2. DTO(object)
     * 주의 : key이름과 변수이름이 동일해야 한다.
     */
    @PostMapping("/join")
    public String join(JoinReqDto joinReqDto) { // DTO로 받는 것이 좋다.
        // 1. post, put일때만 유효성 검사 (이거보다 우선되는 것이 인증 검사이다) null,공백처리
        if (joinReqDto.getUsername() == null || joinReqDto.getUsername().isEmpty()) {
            throw new CustomException("username을 입력하세요", HttpStatus.BAD_REQUEST);
        }
        if (joinReqDto.getPassword() == null || joinReqDto.getPassword().isEmpty()) {
            throw new CustomException("password를 입력하세요", HttpStatus.BAD_REQUEST);
        }
        if (joinReqDto.getFullname() == null || joinReqDto.getFullname().isEmpty()) {
            throw new CustomException("fullname을 입력하세요", HttpStatus.BAD_REQUEST);
        }
        // 컨벤션 : post, put, delete(insert, update, delete) 할때만하기
        // 서비스 호출 => 회원가입();
        userService.회원가입(joinReqDto);

        return "redirect:/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }
}