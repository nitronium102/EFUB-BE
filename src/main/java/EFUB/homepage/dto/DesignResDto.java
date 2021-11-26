package EFUB.homepage.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class DesignResDto {
	private final Long user_id;
	private final Long des_id;
	private final LocalDateTime created_at;
	private final LocalDateTime modified_at;
	private final String motive;
	private final int confidence_des;
	private final List<ToolResDto> tool;
	private final int confidence_tool;
	private final String project_topic;
	private final String exp_dev;
	private final String exp_des;
	private final String link;
	private final Boolean interview;
	private final Boolean orientation;
}
