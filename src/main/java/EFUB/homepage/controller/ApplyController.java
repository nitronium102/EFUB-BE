package EFUB.homepage.controller;

import EFUB.homepage.domain.Position;
import EFUB.homepage.domain.User;
import EFUB.homepage.dto.design.DesReqDto;
import EFUB.homepage.dto.develop.DevReqDto;
import EFUB.homepage.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recruitment/apply")
public class ApplyController {
    private final UserService userService;
    private final ToolService toolService;
    private final DesignService designService;
    private final DevelopService developService;
    private final InterviewService interviewService;

    static final String INVALID_REQUEST = "필수 파라미터 누락";
    static final String SAVE_ERROR = "기존 정보가 존재함";
    static final String UPDATE_ERROR = "기존 정보가 존재하지 않음";

    @PostMapping("/develop")
    // TODO: dto @Valid
    public ResponseEntity<Object> applyDevelop(@RequestBody DevReqDto devReqDto) {
        User user = userService.save(devReqDto.getUser(), Position.Developer);

        toolService.save(user, devReqDto.getTools());
        interviewService.save(user, devReqDto.getInterviews());
        developService.save(user, devReqDto.getApply());

        return ResponseEntity.ok(200);
    }

    @PostMapping("/design")
    public ResponseEntity<Object> applyDesign(@RequestBody DesReqDto desReqDto){
        User user = userService.save(desReqDto.getUser(), Position.Designer);

        toolService.save(user, desReqDto.getTools());
        interviewService.save(user, desReqDto.getInterviews());
        designService.save(user, desReqDto.getApply());

        return ResponseEntity.ok(200);
    }
/*
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
*/
}
