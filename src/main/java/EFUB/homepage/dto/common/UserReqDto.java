package EFUB.homepage.dto.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserReqDto {
	private String name;
	private String studentId;
	private String department;
	private String phoneNo;
	private String password;
}
