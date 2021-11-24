package EFUB.homepage.dto;

import EFUB.homepage.domain.Design;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@NoArgsConstructor
@Data
public class DesignDto {
    private Long user_id;
    private String motive;
    private int confidence_des;
    private int confidence_tool;
    private String project_topic;
    private String exp_dev;
    private String exp_des;
    private String link;
    private Boolean interview;
    private Boolean orientation;

    @Builder
    public DesignDto(Long user_id, String motive, int confidence_des, int confidence_tool, String project_topic,
                     String exp_des, String exp_dev, String link, Boolean interview, Boolean orientation){
        this.user_id = user_id;
        this.motive = motive;
        this.confidence_des = confidence_des;
        this.confidence_tool = confidence_tool;
        this.project_topic = project_topic;
        this.exp_des  = exp_des;
        this.exp_dev = exp_dev;
        this.link = link;
        this.interview = interview;
        this.orientation = orientation;
    }

    public Design toEntity(){
        return Design.builder()
                .userId(this.user_id)
                .motive(this.motive)
                .confidenceDes(this.confidence_des)
                .confidenceTool(this.confidence_tool)
                .projectTopic(this.project_topic)
                .expDes(this.exp_des)
                .expDev(this.exp_dev)
                .link(this.link)
                .interview(this.interview)
                .orientation(this.orientation)
                .build();
    }
}
