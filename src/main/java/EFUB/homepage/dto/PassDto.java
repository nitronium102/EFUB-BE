package EFUB.homepage.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PassDto {
	private String name;
	private String phoneNo;
	private String password;

	@Builder
	public PassDto(String name, String phoneNo, String password) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.password = password;
	}
}
