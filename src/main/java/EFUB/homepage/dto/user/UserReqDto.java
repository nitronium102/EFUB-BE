package EFUB.homepage.dto.user;

import EFUB.homepage.domain.Position;
import EFUB.homepage.domain.User;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserReqDto {
	@NotBlank
	private String name;
	@NotBlank
	private String studentId;
	@NotBlank
	private String department;
	@NotBlank
	private String phoneNo;
	@NotBlank
	private String password;

	@Builder
	public UserReqDto(String name, String studentId, String department, String phoneNo, String password) {
		this.name = name;
		this.studentId = studentId;
		this.department = department;
		this.phoneNo = phoneNo;
		this.password = password;
	}

	public User toEntity(UserReqDto user, Position position) {
		return User.builder()
				.name(user.getName())
				.password(user.getPassword())
				.phoneNo(user.getPhoneNo())
				.studentId(user.getStudentId())
				.department(user.getDepartment())
				.position(position)
				.build();
	}

	public void encryptPassword(PasswordEncoder passwordEncoder){
		this.password = passwordEncoder.encode(password);
	}
}
