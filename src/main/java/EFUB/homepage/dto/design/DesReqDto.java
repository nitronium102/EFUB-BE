package EFUB.homepage.dto.design;

import EFUB.homepage.dto.common.UserReqDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DesReqDto {
	private UserReqDto user;
	private List<String> tools;
	private List<String> interviews;
	private DesApplyDto apply;
}