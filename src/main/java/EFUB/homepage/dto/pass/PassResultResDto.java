package EFUB.homepage.dto.pass;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PassResultResDto {
	private String result;

	@Builder
	public PassResultResDto(String result) {
		this.result = result;
	}
}