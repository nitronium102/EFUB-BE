package EFUB.homepage.dto;

import EFUB.homepage.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDto {
    private String name;
    private Long studentId;
    private String department;
    private String phoneNo;
    private String password;
    private Integer position;

    @Builder
    public UserRequestDto(User entity){
        this.name = entity.getName();
        this.studentId = entity.getStudentId();
        this.department = entity.getDepartment();
        this.phoneNo = entity.getPhoneNo();
        this.password = entity.getPassword();
        this.position = entity.getPosition();

    }

}
