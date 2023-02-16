package shop.mtcoding.newblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.newblog.dto.account.AccountSaveReqDto;
import shop.mtcoding.newblog.model.account.Account;
import shop.mtcoding.newblog.model.account.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void 계좌생성(AccountSaveReqDto accountSaveReqDto, int principalId) {
        Account account = accountSaveReqDto.toModel(principalId);
        accountRepository.insert(account);
    }
}
