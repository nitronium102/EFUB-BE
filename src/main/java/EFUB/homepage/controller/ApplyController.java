package EFUB.homepage.controller;

import EFUB.homepage.domain.Develop;
import EFUB.homepage.dto.DevelopDto;
import EFUB.homepage.dto.SaveDevelopDto;
import EFUB.homepage.service.DevelopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recruitment/apply")
public class ApplyController {
    private final DevelopService developService;

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

        //tool 저장

        Develop develop = developService.save(developDto);
        //null 처리
        return ResponseEntity.ok(200);
    }

}
