package EFUB.homepage.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class ToolResDto {
	private final Long user_id;
	private final Long tool_id;
	private final String tool_name;
}

