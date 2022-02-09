package EFUB.homepage.dto.design;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DesApplyDto {
	@NotBlank
	private String motive;
	private Integer confidenceTool;
	@NotBlank
	private String activityPlan;
	@NotBlank
	private String expSolve;
	private String link;
	@NotNull
	private Boolean orientation;
}
