package EFUB.homepage.dto;

import EFUB.homepage.domain.Interview;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class InterviewDto {
    private Long user_id;
    private String date;

    @Builder
    public InterviewDto(Long user_id, String date){
        this.user_id = user_id;
        this.date = date;
    }

    public Interview toEntity(){
        return Interview.builder()
                .userId(this.user_id)
                .date(this.date)
                .build();
    }
}
