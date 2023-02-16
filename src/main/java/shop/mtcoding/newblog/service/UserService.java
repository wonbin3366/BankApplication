package shop.mtcoding.newblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.newblog.dto.user.JoinReqDto;
import shop.mtcoding.newblog.handler.ex.CustomException;
import shop.mtcoding.newblog.model.user.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional // 회원가입 메서드 호출이 시작될때, 트랜잭션 시작, 끝날때, 트랜잭션 종료(commit)
    public void 회원가입(JoinReqDto joinReqDto) {
        // mybatis는 인수로 들어온 오브젝트의 변수명으로 자동 매핑해준다.
        int result = userRepository.insert(joinReqDto.toModel());
        if (result != 1) {
            throw new CustomException("회원가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
