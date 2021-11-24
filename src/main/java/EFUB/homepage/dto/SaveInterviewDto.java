package EFUB.homepage.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SaveInterviewDto {
    private String date;

    @Builder
    public SaveInterviewDto(String date){
        this.date = date;
    }
}
