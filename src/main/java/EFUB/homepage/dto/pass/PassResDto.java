package EFUB.homepage.dto.pass;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PassResDto {
	private String result;

	@Builder
	public PassResDto(String result) {
		this.result = result;
	}
}