package EFUB.homepage.dto.develop;

import EFUB.homepage.dto.application.BasicApplyDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class DevInternResDto extends BasicApplyDto {
	private Long developId;
	private String motive;
	private String projectTopic;
	private String applicationField;
	private String language;
	private Integer confidenceLang;
	private String link;
	private Boolean orientation;
	private String expProject;
	private String expStudy;

	@Builder
	public DevInternResDto(Long developId, String motive, String projectTopic, String applicationField, String language, Integer confidenceLang, String link, Boolean orientation, String expProject, String expStudy, List<String> tools, List<String> interviews) {
		super(tools, interviews);
		this.developId = developId;
		this.motive = motive;
		this.projectTopic = projectTopic;
		this.applicationField = applicationField;
		this.language = language;
		this.confidenceLang = confidenceLang;
		this.link = link;
		this.orientation = orientation;
		this.expProject = expProject;
		this.expStudy = expStudy;
	}
}
