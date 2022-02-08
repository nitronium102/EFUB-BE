package EFUB.homepage.dto.develop;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DevInternApplyDto {
	@NotBlank
	private String motive;
	@NotBlank
	private String projectTopic;
	@NotBlank
	private String applicationField;
	private String language;
	private Integer confidenceLang;
	private String link;
	@NotNull
	private Boolean orientation;
	@NotBlank
	private String expProject;
	@NotBlank
	private String expStudy;
}
