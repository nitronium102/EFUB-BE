package EFUB.homepage.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class UpdateDevelopDto {
    private Long user_id;
    private Long dev_id;
    private String motive;
    private String project_topic;
    private String application_field;
    private String language;
    private int confidence_lang;
    private List<SaveToolDto> tool;
    private String exp;
    private String link;
    private Boolean orientation;
    private List<SaveInterviewDto> interview;

    @Builder
    public UpdateDevelopDto(Long user_id, Long dev_id, String motive, String project_topic, String application_field,
                          String language, int confidence_lang, List<SaveToolDto> tool,
                          String exp, String link, Boolean orientation, List<SaveInterviewDto> interview){
        this.user_id = user_id;
        this.dev_id = dev_id;
        this.motive = motive;
        this.project_topic = project_topic;
        this.application_field = application_field;
        this.language = language;
        this.confidence_lang = confidence_lang;
        this.tool = tool;
        this.exp = exp;
        this.link = link;
        this.orientation = orientation;
        this.interview = interview;
    }

}
