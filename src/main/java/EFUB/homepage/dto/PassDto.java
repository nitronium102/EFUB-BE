package EFUB.homepage.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PassDto {
	private String name;
	private Long student_id;
	private String password;

	@Builder
	public PassDto(String name, Long student_id, String password){
		this.name = name;
		this.student_id = student_id;
		this.password = password;
	}
}
