package EFUB.homepage.domain;

import EFUB.homepage.dto.DevelopResDto;
import EFUB.homepage.dto.InterviewResDto;
import EFUB.homepage.dto.ToolResDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name="Develop")
@Entity
public class Develop extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dev_id", nullable = false)
    private Long devId;
    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name="motive", length=350)
    private String motive;
    @Column(name="project_topic")
    private String projectTopic;
    @Column(name="application_field")
    private String applicationField;
    @Column(name="language")
    private String language;
    @Column(name="confidence_lang")
    private int confidenceLang;
    @Column(name="exp", length=1000)
    private String exp;
    @Column(name="link")
    private String link;
    @Column(name="orientation")
    private Boolean orientation;

    @Builder
    public Develop(Long userId, String motive, String projectTopic, String applicationField,
                   String language, int confidenceLang, String exp, String link, Boolean orientation){
        this.userId = userId;
        this.motive = motive;
        this.projectTopic = projectTopic;
        this.applicationField = applicationField;
        this.language = language;
        this.confidenceLang = confidenceLang;
        this.exp = exp;
        this.link = link;
        this.orientation = orientation;
    }

    public void update(String motive, String projectTopic, String applicationField, String language,
                  int confidenceLang, String exp, String link, Boolean orientation){
        this.motive = motive;
        this.projectTopic = projectTopic;
        this.applicationField = applicationField;
        this.language = language;
        this.confidenceLang = confidenceLang;
        this.exp = exp;
        this.link = link;
        this.orientation = orientation;
    }

    public DevelopResDto toDevelopResDto(List<ToolResDto> tools, List<InterviewResDto> interviews) {
        return DevelopResDto.builder()
            .user_id(this.userId)
            .dev_id(this.devId)
            .created_at(this.getCreatedAt())
            .modified_at(this.getModifiedAt())
            .motive(this.motive)
            .project_topic(this.projectTopic)
            .application_field(this.applicationField)
            .language(this.language)
            .confidence_lang(this.confidenceLang)
            .tool(tools)
            .exp(this.exp)
            .link(this.link)
            .orientation(this.orientation)
            .interview(interviews)
            .build();
    }
}
