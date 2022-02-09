package EFUB.homepage.dto.develop;

import EFUB.homepage.dto.user.UserReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class DevLeadReqDto {
	private UserReqDto user;
	private List<String> tools;
	private List<String> interviews;
	private DevLeadApplyDto apply;
}
