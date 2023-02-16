package shop.mtcoding.newblog.dto.account;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountWithdrawReqDto {
    // Dto는 wrapper클래스로 만들어야 null 체크가 가능해진다.
    private Long amount;
    private String wAccountNumber;
    private String wAccountPassword;
}
