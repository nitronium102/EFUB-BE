package EFUB.homepage.dto.login;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class LoginReqDto {

    @NotBlank
    private String adminId;

    @NotBlank
    private String password;

    @Builder
    public LoginReqDto(String adminId, String password) {
        this.adminId = adminId;
        this.password = password;
    }
}
