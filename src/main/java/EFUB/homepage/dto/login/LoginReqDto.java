package EFUB.homepage.dto.login;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginReqDto {

    private String adminId;
    private String password;

    @Builder
    public LoginReqDto(String adminId, String password) {
        this.adminId = adminId;
        this.password = password;
    }
}
