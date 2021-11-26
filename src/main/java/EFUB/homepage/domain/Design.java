package EFUB.homepage.domain;

import EFUB.homepage.dto.DesignResDto;
import EFUB.homepage.dto.ToolResDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name="Design")
@Entity
public class Design extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="des_id", nullable = false)
    private Long desId;
    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name="motive", columnDefinition = "TEXT", nullable = false)
    private String motive;
    @Column(name="confidence_des", nullable = false)
    private int confidenceDes;
    @Column(name="confidence_tool", nullable = false)
    private int confidenceTool;
    @Column(name="project_topic", columnDefinition = "TEXT", nullable = false)
    private String projectTopic;
    @Column(name="exp_dev", columnDefinition = "TEXT")
    private String expDev;
    @Column(name="exp_des", columnDefinition = "TEXT")
    private String expDes;
    @Column(name="link")
    private String link;
    @Column(name="interview", nullable = false)
    private Boolean interview;
    @Column(name="orientation", nullable = false)
    private Boolean orientation;

    @Builder
    public Design(Long userId, String motive, int confidenceDes, int confidenceTool, String projectTopic,
                  String expDes, String expDev, String link, Boolean interview, Boolean orientation){
        this.userId = userId;
        this.motive = motive;
        this.confidenceDes = confidenceDes;
        this.confidenceTool = confidenceTool;
        this.projectTopic = projectTopic;
        this.expDes = expDes;
        this.expDev = expDev;
        this.link = link;
        this.interview = interview;
        this.orientation = orientation;
    }

    public void update(String motive, int confidenceDes, int confidenceTool, String projectTopic,
                  String expDes, String expDev, String link, Boolean interview, Boolean orientation){
        this.motive = motive;
        this.confidenceDes = confidenceDes;
        this.confidenceTool = confidenceTool;
        this.projectTopic = projectTopic;
        this.expDes = expDes;
        this.expDev = expDev;
        this.link = link;
        this.interview = interview;
        this.orientation = orientation;
    }

    public DesignResDto toDesignResDto(List<ToolResDto> tools) {
        return DesignResDto.builder()
            .user_id(this.userId)
            .des_id(this.desId)
            .created_at(this.getCreatedAt())
            .modified_at(this.getModifiedAt())
            .motive(this.motive)
            .confidence_des(this.confidenceDes)
            .tool(tools)
            .confidence_tool(this.confidenceTool)
            .project_topic(this.projectTopic)
            .exp_dev(this.expDev)
            .exp_des(this.expDes)
            .link(this.link)
            .interview(this.interview)
            .orientation(this.orientation)
            .build();
    }
}
