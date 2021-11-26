package EFUB.homepage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class DevelopResDto {
	private final Long user_id;
	private final Long dev_id;
	private final LocalDateTime created_at;
	private final LocalDateTime modified_at;
	private final String motive;
	private final String project_topic;
	private final String application_field;
	private final String language;
	private final int confidence_lang;
	private final List<ToolResDto> tool;
	private final String exp;
	private final String link;
	private final Boolean orientation;
	private final List<InterviewResDto> interview;

}