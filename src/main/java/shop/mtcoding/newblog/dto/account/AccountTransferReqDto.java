package shop.mtcoding.newblog.dto.account;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountTransferReqDto {
    private Long amount;
    private String wAccountNumber;
    private String dAccountNumber;
    private String wAccountPassword;
}
