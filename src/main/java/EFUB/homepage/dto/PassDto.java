package EFUB.homepage.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PassDto {
	private String name;
	private String phone_no;
	private String password;

	@Builder
	public PassDto(String name, String phone_no, String password) {
		this.name = name;
		this.phone_no = phone_no;
		this.password = password;
	}
}
