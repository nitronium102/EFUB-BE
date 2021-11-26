package EFUB.homepage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class InterviewResDto {
	private final Long interview_id;
	private final Long user_id;
	private final String date;
}

