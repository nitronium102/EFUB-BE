package EFUB.homepage.dto.pass;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PassResultResDto {
	private String result;

	@Builder
	public PassResultResDto(String result) {
		this.result = result;
	}
}