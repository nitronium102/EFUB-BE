package EFUB.homepage.dto.design;

import EFUB.homepage.dto.user.UserReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Getter
@NoArgsConstructor
public class DesReqDto {
	@Valid
	private UserReqDto user;
	private List<String> tools;
	private List<String> interviews;
	@Valid
	private DesApplyDto apply;
}