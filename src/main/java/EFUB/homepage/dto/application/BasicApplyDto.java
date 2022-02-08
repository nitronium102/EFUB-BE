package EFUB.homepage.dto.application;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BasicApplyDto {
	protected List<String> tools;
	protected List<String> interviews;

	public BasicApplyDto(List<String> tools, List<String> interviews) {
		this.tools = tools;
		this.interviews = interviews;
	}
}
