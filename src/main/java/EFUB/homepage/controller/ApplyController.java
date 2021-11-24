package EFUB.homepage.controller;

import EFUB.homepage.domain.Develop;
import EFUB.homepage.dto.*;
import EFUB.homepage.service.DesignService;
import EFUB.homepage.service.DevelopService;
import EFUB.homepage.service.InterviewService;
import EFUB.homepage.service.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recruitment/apply")
public class ApplyController {
    private final DevelopService developService;
    private final DesignService designService;
    private final ToolService toolService;
    private final InterviewService interviewService;

    //save_final 처리
    @PostMapping("/save/dev")
    public ResponseEntity saveDevelop(@RequestBody SaveDevelopDto saveDevelopDto){
        DevelopDto developDto = DevelopDto.builder()
                .user_id(saveDevelopDto.getUser_id())
                .motive(saveDevelopDto.getMotive())
                .project_topic(saveDevelopDto.getProject_topic())
                .application_field(saveDevelopDto.getApplication_field())
                .language(saveDevelopDto.getLanguage())
                .confidence_lang(saveDevelopDto.getConfidence_lang())
                .exp(saveDevelopDto.getExp())
                .link(saveDevelopDto.getLink())
                .orientation(saveDevelopDto.getOrientation())
                .build();

        Long userId = saveDevelopDto.getUser_id();
        List<SaveToolDto> toolList = saveDevelopDto.getTool();
        for(SaveToolDto tool: toolList){
            ToolDto toolDto = ToolDto.builder()
                    .user_id(userId)
                    .tool(tool.getTool_name())
                    .build();
            toolService.save(toolDto);
        }

        List<SaveInterviewDto> interviewList = saveDevelopDto.getInterview();
        for(SaveInterviewDto interview: interviewList){
            InterviewDto interviewDto = InterviewDto.builder()
                    .user_id(userId)
                    .date(interview.getDate())
                    .build();
            interviewService.save(interviewDto);
        }

        Develop develop = developService.save(developDto);

        //null 처리
        return ResponseEntity.ok(200);
    }

    @PostMapping("/save/des")
    public ResponseEntity saveDesign(@RequestBody SaveDesignDto saveDesignDto){
        DesignDto designDto = DesignDto.builder()
                .user_id(saveDesignDto.getUser_id())
                .motive(saveDesignDto.getMotive())
                .confidence_des(saveDesignDto.getConfidence_des())
                .confidence_tool(saveDesignDto.getConfidence_tool())
                .project_topic(saveDesignDto.getProject_topic())
                .exp_des(saveDesignDto.getExp_des())
                .exp_dev(saveDesignDto.getExp_dev())
                .link(saveDesignDto.getLink())
                .interview(saveDesignDto.getInterview())
                .orientation(saveDesignDto.getOrientation())
                .build();

        Long userId = saveDesignDto.getUser_id();
        List<SaveToolDto> toolList = saveDesignDto.getTool();
        for(SaveToolDto tool: toolList){
            ToolDto toolDto = ToolDto.builder()
                    .user_id(userId)
                    .tool(tool.getTool_name())
                    .build();
            toolService.save(toolDto);
        }

        designService.save(designDto);
        //null 처리

        return ResponseEntity.ok(200);
    }


}
