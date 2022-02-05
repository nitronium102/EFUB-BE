package EFUB.homepage.dto.user;

import EFUB.homepage.domain.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResDto {
	private Long userId;
	private Position position;
	private String name;
	private String studentId;
	private String department;
	private String phoneNo;
	private Boolean passMid;
	private Boolean passFinal;

	@Builder
	public UserResDto(Long userId, Position position, String name, String studentId, String department, String phoneNo, Boolean passMid, Boolean passFinal) {
		this.userId = userId;
		this.position = position;
		this.name = name;
		this.studentId = studentId;
		this.department = department;
		this.phoneNo = phoneNo;
		this.passMid = passMid;
		this.passFinal = passFinal;
	}
}
