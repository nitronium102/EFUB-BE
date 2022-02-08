package EFUB.homepage.dto.design;

import EFUB.homepage.dto.user.UserReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class DesReqDto {
	private UserReqDto user;
	private List<String> tools;
	private List<String> interviews;
	private DesApplyDto apply;
}