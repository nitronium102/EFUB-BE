package EFUB.homepage.dto.user;

import EFUB.homepage.domain.Position;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResDto {
	private Long userId;
	private String name;
	private String studentId;
	private String department;
	private String phoneNo;
	private Position position;
	private String applicationUri;
	private Boolean passMid;
	private Boolean passFinal;

	@Builder
	public UserResDto(Long userId, String name, String studentId, String department, String phoneNo, Position position, String applicationUri, Boolean passMid, Boolean passFinal) {
		this.userId = userId;
		this.name = name;
		this.studentId = studentId;
		this.department = department;
		this.phoneNo = phoneNo;
		this.position = position;
		this.applicationUri = applicationUri;
		this.passMid = passMid;
		this.passFinal = passFinal;
	}
}
