package EFUB.homepage.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PassResponseDto {
	private String result;

	@Builder
	public PassResponseDto(String result) {
		this.result = result;
	}
}
