package EFUB.homepage.dto;

import EFUB.homepage.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDto {
    private String name;
    private Long student_id;
    private String department;
    private String phone_no;
    private String password;
    private Integer position;

    @Builder
    public UserRequestDto(User entity){
        this.name = entity.getName();
        this.student_id = entity.getStudentId();
        this.department = entity.getDepartment();
        this.phone_no = entity.getPhoneNo();
        this.password = entity.getPassword();
        this.position = entity.getPosition();
    }

}
