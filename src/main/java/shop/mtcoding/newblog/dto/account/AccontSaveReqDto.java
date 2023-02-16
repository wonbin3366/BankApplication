package shop.mtcoding.newblog.dto.account;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccontSaveReqDto {
    private String number;
    private String password;
    private Long balance;
    private int userId;
    private Timestamp createdAt;
}
