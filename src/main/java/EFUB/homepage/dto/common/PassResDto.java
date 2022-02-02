package EFUB.homepage.dto.common;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PassResDto {
	private Long count;
	private List<UserResDto> users;

	@Builder
	public PassResDto(Long count, List<UserResDto> users) {
		this.count = count;
		this.users = users;
	}
}
