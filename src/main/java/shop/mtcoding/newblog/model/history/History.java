package shop.mtcoding.newblog.model.history;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class History {
    private Integer id;
    private Long amount;
    private Long wBalance; // 출금계좌잔액
    private Long dBalance; // 입금계좌잔액
    private Integer wAccountId;
    private Integer dAccountId;
    private Timestamp createdAt;
}
