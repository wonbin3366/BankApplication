package shop.mtcoding.newblog.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import shop.mtcoding.newblog.handler.ex.CustomException;

@RestControllerAdvice // 오류나면 무조건 데이터를 리턴한다
public class MyExceptionHandler {

    // 자바스크립트를 응답
    @ExceptionHandler(CustomException.class)
    public String basicException(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append("<script>");
        sb.append("alert('" + e.getMessage() + "');");
        sb.append("history.back();");
        sb.append("</script>");
        return sb.toString();
    }

    // DTO를 응답(ajax)
}
