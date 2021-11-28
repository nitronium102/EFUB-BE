package EFUB.homepage.controller;

import EFUB.homepage.domain.Design;
import EFUB.homepage.domain.Develop;
import EFUB.homepage.domain.Interview;
import EFUB.homepage.domain.Tool;
import EFUB.homepage.dto.*;
import EFUB.homepage.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recruitment/apply")
public class ApplyController {
    private final DevelopService developService;
    private final DesignService designService;
    private final ToolService toolService;
    private final InterviewService interviewService;
    private final UserService userService;

    static final String INVALID_REQUEST = "필수 파라미터 누락";
    static final String SAVE_ERROR = "기존 정보가 존재함";
    static final String UPDATE_ERROR = "기존 정보가 존재하지 않음";

    @PostMapping("/save/dev")
    public ResponseEntity saveDevelop(@RequestBody SaveDevelopDto saveDevelopDto,
                                      @RequestParam(required = false) Boolean saveFinal) {
        if(ObjectUtils.isEmpty(saveDevelopDto.getUser_id())){
            return ResponseEntity.badRequest().body(INVALID_REQUEST);
        }
        if(developService.checkByUserId(saveDevelopDto.getUser_id())){
            return ResponseEntity.internalServerError().body(SAVE_ERROR);
        }

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
        if(!ObjectUtils.isEmpty(toolList)){
            for(SaveToolDto tool: toolList){
                ToolDto toolDto = ToolDto.builder()
                        .user_id(userId)
                        .tool(tool.getTool_name())
                        .build();
                toolService.save(toolDto);
            }
        }

        List<SaveInterviewDto> interviewList = saveDevelopDto.getInterview();
        if(!ObjectUtils.isEmpty(interviewList)){
            for(SaveInterviewDto interview: interviewList){
                InterviewDto interviewDto = InterviewDto.builder()
                        .user_id(userId)
                        .date(interview.getDate())
                        .build();
                interviewService.save(interviewDto);
            }
        }

        Develop develop = developService.save(developDto);

        if (saveFinal != null && saveFinal)
            userService.saveFinal(develop.getUserId());

        return ResponseEntity.ok(200);
    }

    @PostMapping("/save/des")
    public ResponseEntity saveDesign(@RequestBody SaveDesignDto saveDesignDto,
                                     @RequestParam(required = false) Boolean saveFinal) {
        if(ObjectUtils.isEmpty(saveDesignDto.getUser_id())){
            return ResponseEntity.badRequest().body(INVALID_REQUEST);
        }
        if(designService.checkByUserId(saveDesignDto.getUser_id())){
            return ResponseEntity.internalServerError().body(SAVE_ERROR);
        }

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
        if(!ObjectUtils.isEmpty(toolList)){
            for(SaveToolDto tool: toolList){
                ToolDto toolDto = ToolDto.builder()
                        .user_id(userId)
                        .tool(tool.getTool_name())
                        .build();
                toolService.save(toolDto);
            }
        }

        Design design = designService.save(designDto);

        if (saveFinal != null && saveFinal)
            userService.saveFinal(design.getUserId());

        return ResponseEntity.ok(200);
    }

    @PostMapping("/update/dev")
    public ResponseEntity updateDevelop(@RequestBody UpdateDevelopDto updateDevelopDto,
                                        @RequestParam(required = false) Boolean saveFinal) {
        if(ObjectUtils.isEmpty(updateDevelopDto.getUser_id())){
            return ResponseEntity.badRequest().body(INVALID_REQUEST);
        }

        boolean isUpdate = developService.update(updateDevelopDto);
        if(!isUpdate){
            return ResponseEntity.internalServerError().body(UPDATE_ERROR);
        }

        Long userId = updateDevelopDto.getUser_id();
        List<Tool> toolList = toolService.findByUserId(userId);
        if(!ObjectUtils.isEmpty(toolList)){
            for(Tool tool: toolList){
                toolService.delete(tool.getToolId());
            }
        }
        List<Interview> interviewList = interviewService.findByUserId(userId);
        if(!ObjectUtils.isEmpty(interviewList)){
            for(Interview interview: interviewList){
                interviewService.delete(interview.getInterviewId());
            }
        }

        List<SaveToolDto> newToolList = updateDevelopDto.getTool();
        if(!ObjectUtils.isEmpty(newToolList)){
            for(SaveToolDto newTool: newToolList){
                toolService.save(ToolDto.builder()
                        .user_id(userId)
                        .tool(newTool.getTool_name())
                        .build());
            }
        }
        List<SaveInterviewDto> newInterviewList = updateDevelopDto.getInterview();
        if(!ObjectUtils.isEmpty(newInterviewList)){
            for(SaveInterviewDto newInterview: newInterviewList){
                interviewService.save(InterviewDto.builder()
                        .user_id(userId)
                        .date(newInterview.getDate())
                        .build());
            }

        }

        if (saveFinal != null && saveFinal)
            userService.saveFinal(userId);

        return ResponseEntity.ok(200);
    }

    @PostMapping("/update/des")
    public ResponseEntity updateDesign(@RequestBody UpdateDesignDto updateDesignDto,
                                       @RequestParam(required = false) Boolean saveFinal) {
        if(ObjectUtils.isEmpty(updateDesignDto.getUser_id())){
            return ResponseEntity.badRequest().body(INVALID_REQUEST);
        }
        boolean isUpdate = designService.update(updateDesignDto);
        if(!isUpdate){
            return ResponseEntity.internalServerError().body(UPDATE_ERROR);
        }

        Long userId = updateDesignDto.getUser_id();
        List<Tool> toolList = toolService.findByUserId(userId);
        if(!ObjectUtils.isEmpty(toolList)){
            for(Tool tool: toolList){
                toolService.delete(tool.getToolId());
            }
        }
        List<SaveToolDto> newToolList = updateDesignDto.getTool();
        if(!ObjectUtils.isEmpty(newToolList)){
            for(SaveToolDto newTool: newToolList){
                toolService.save(ToolDto.builder()
                        .user_id(userId)
                        .tool(newTool.getTool_name())
                        .build());
            }
        }

        if (saveFinal != null && saveFinal)
            userService.saveFinal(userId);

        return ResponseEntity.ok(200);
    }

    @PostMapping("/get/des")
    public ResponseEntity<Object> getDesign(final @RequestBody UidDto uidDto) {
        if (uidDto == null || uidDto.getUser_id() == null)
            return ResponseEntity.badRequest().body(INVALID_REQUEST);

        if (userService.isSaveFinal(uidDto.getUser_id()))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(designService.getDesign(uidDto.getUser_id()));
    }

    @PostMapping("/get/dev")
    public ResponseEntity<Object> getDevelop(final @RequestBody UidDto uidDto) {
        if (uidDto == null || uidDto.getUser_id() == null)
            return ResponseEntity.badRequest().body(INVALID_REQUEST);

        if (userService.isSaveFinal(uidDto.getUser_id()))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(developService.getDevelop(uidDto.getUser_id()));
    }
}
