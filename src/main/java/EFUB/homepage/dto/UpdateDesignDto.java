package EFUB.homepage.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class UpdateDesignDto {
    private Long user_id;
    private Long des_id;
    private String motive;
    private int confidence_des;
    private List<SaveToolDto> tool;
    private int confidence_tool;
    private String project_topic;
    private String exp_dev;
    private String exp_des;
    private String link;
    private Boolean interview;
    private Boolean orientation;

    @Builder
    public UpdateDesignDto(Long user_id, Long des_id, String motive, int confidence_des, List<SaveToolDto> tool,
                         int confidence_tool, String project_topic, String exp_des, String exp_dev,
                         String link, Boolean interview, Boolean orientation){
        this.user_id = user_id;
        this.des_id = des_id;
        this.motive = motive;
        this.confidence_des = confidence_des;
        this.tool = tool;
        this.confidence_tool = confidence_tool;
        this.project_topic = project_topic;
        this.exp_des  = exp_des;
        this.exp_dev = exp_dev;
        this.link = link;
        this.interview = interview;
        this.orientation = orientation;
    }
}
