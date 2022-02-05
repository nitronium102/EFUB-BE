package EFUB.homepage.dto.develop;

import EFUB.homepage.dto.user.UserReqDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DevReqDto {
	private UserReqDto user;
	private List<String> tools;
	private List<String> interviews;
	private DevApplyDto apply;
}
