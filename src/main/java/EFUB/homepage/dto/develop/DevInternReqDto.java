package EFUB.homepage.dto.develop;

import EFUB.homepage.dto.user.UserReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@NoArgsConstructor
@Getter
public class DevInternReqDto {
	@Valid
	private UserReqDto user;
	private List<String> tools;
	private List<String> interviews;
	@Valid
	private DevInternApplyDto apply;
}