package shop.mtcoding.newblog.dto.account;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.newblog.model.account.Account;

@Setter
@Getter
public class AccountSaveReqDto {
    private String number;
    private String password;

    // insert, update 할 때 이 메서드가 DTO에 필요하다.
    public Account toModel(int principalId) {
        Account account = new Account();
        account.setNumber(number);
        account.setPassword(password);
        account.setUserId(principalId);
        account.setBalance(1000L);
        return account;
    }
}
