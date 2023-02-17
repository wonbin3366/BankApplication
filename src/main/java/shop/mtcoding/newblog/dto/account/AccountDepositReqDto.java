package shop.mtcoding.newblog.dto.account;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountDepositReqDto {
    // Dto는 wrapper클래스로 만들어야 null 체크가 가능해진다.
    // Dto는 똑같은게 존재해도 공유해서 쓰지않는다.
    // 이유는 DTO는 화면에 나타나는 데이터(자주 변경될 수 있음)
    private Long amount;
    private String dAccountNumber;
}
