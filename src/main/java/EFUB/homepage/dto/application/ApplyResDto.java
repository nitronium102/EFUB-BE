package EFUB.homepage.dto.application;

import EFUB.homepage.dto.user.UserResDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApplyResDto {
	private UserResDto user;
	private Object apply;

	@Builder
	public ApplyResDto(UserResDto user, Object apply) {
		this.user = user;
		this.apply = apply;
	}
}
