package EFUB.homepage.dto;

import EFUB.homepage.domain.Develop;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
public class DevelopDto {
    private Long user_id;
    private String motive;
    private String project_topic;
    private String application_field;
    private String language;
    private int confidence_lang;
    private String exp;
    private String link;
    private Boolean orientation;

    @Builder
    public DevelopDto(Long user_id, String motive, String project_topic, String application_field,
                      String language, int confidence_lang, String exp, String link, Boolean orientation){
        this.user_id = user_id;
        this.motive = motive;
        this.project_topic = project_topic;
        this.application_field = application_field;
        this.language = language;
        this.confidence_lang = confidence_lang;
        this.exp = exp;
        this.link = link;
        this.orientation = orientation;
    }

    public Develop toEntity(){
        return Develop.builder()
                .userId(this.user_id)
                .motive(this.motive)
                .projectTopic(this.project_topic)
                .applicationField(this.application_field)
                .language(this.language)
                .confidenceLang(this.confidence_lang)
                .exp(this.exp)
                .link(this.link)
                .orientation(this.orientation)
                .build();
    }
}
