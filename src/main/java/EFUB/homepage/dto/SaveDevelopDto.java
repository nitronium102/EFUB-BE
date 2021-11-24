package EFUB.homepage.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class SaveDevelopDto {
    private Long user_id;
    private String motive;
    private String project_topic;
    private String application_field;
    private String language;
    private int confidence_lang;
    private List<SaveToolDto> tool;
    private String exp;
    private String link;
    private Boolean orientation;

    @Builder
    public SaveDevelopDto(Long user_id, String motive, String project_topic, String application_field,
                          String language, int confidence_lang, List<SaveToolDto> tool,
                          String exp, String link, Boolean orientation){
        this.user_id = user_id;
        this.motive = motive;
        this.project_topic = project_topic;
        this.application_field = application_field;
        this.language = language;
        this.confidence_lang = confidence_lang;
        this.tool = tool;
        this.exp = exp;
        this.link = link;
        this.orientation = orientation;
    }

}
