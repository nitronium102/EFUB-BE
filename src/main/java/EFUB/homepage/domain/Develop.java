package EFUB.homepage.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name="motive", nullable = false)
    private String motive;
    @Column(name="project_topic", nullable = false)
    private String projectTopic;
    @Column(name="application_field", nullable = false)
    private String applicationField;
    @Column(name="language", nullable = false)
    private String language;
    @Column(name="confidence_lang", nullable = false)
    private int confidenceLang;
    @Column(name="exp", nullable = false)
    private String exp;
    @Column(name="link", nullable = true)
    private String link;
    @Column(name="orientation", nullable = false)
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
}
