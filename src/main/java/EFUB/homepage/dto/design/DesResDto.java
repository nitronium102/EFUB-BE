package EFUB.homepage.dto.design;

import EFUB.homepage.dto.application.BasicApplyDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class DesResDto extends BasicApplyDto {
	private Long designId;
	private String motive;
	private Integer confidenceTool;
	private String activityPlan;
	private String expSolve;
	private String link;
	private Boolean orientation;

	@Builder
	public DesResDto(List<String> tools, List<String> interviews, Long designId, String motive, Integer confidenceTool, String activityPlan, String expSolve, String link, Boolean orientation) {
		super.tools =tools;
		super.interviews = interviews;
		this.designId = designId;
		this.motive = motive;
		this.confidenceTool = confidenceTool;
		this.activityPlan = activityPlan;
		this.expSolve = expSolve;
		this.link = link;
		this.orientation = orientation;
	}
}
