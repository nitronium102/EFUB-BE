package EFUB.homepage.dto;

import EFUB.homepage.domain.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long userId;
    private Boolean saveFinal;

    public UserResponseDto(User entity){
        this.userId = entity.getUserId();
        this.saveFinal = entity.getSaveFinal();
    }
}
