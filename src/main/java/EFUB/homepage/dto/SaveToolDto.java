package EFUB.homepage.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SaveToolDto {
    private String tool_name;

    @Builder
    public SaveToolDto(String tool_name){
        this.tool_name = tool_name;
    }
}
