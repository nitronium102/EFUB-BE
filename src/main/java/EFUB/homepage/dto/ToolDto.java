package EFUB.homepage.dto;

import EFUB.homepage.domain.Tool;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ToolDto {
    private Long user_id;
    private String tool;

    @Builder
    public ToolDto(Long user_id, String tool){
        this.user_id = user_id;
        this.tool = tool;
    }

    public Tool toEntity(){
        return Tool.builder()
                .userId(this.user_id)
                .tool(this.tool)
                .build();
    }
}
