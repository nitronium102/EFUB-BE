package EFUB.homepage.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name="motive", nullable = false)
    private String motive;
    @Column(name="confidence_des", nullable = false)
    private int confidenceDes;
    @Column(name="confidence_tool", nullable = false)
    private int confidenceTool;
    @Column(name="project_topic", nullable = false)
    private String projectTopic;
    @Column(name="exp_dev")
    private String expDev;
    @Column(name="exp_des")
    private String expDes;
    @Column(name="link")
    private String link;
    @Column(name="interview", nullable = false)
    private Boolean interview;
    @Column(name="orientation", nullable = false)
    private Boolean orientation;

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
}
