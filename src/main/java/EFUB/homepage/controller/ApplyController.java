package EFUB.homepage.controller;

import EFUB.homepage.domain.Position;
import EFUB.homepage.domain.User;
import EFUB.homepage.dto.design.DesReqDto;
import EFUB.homepage.dto.develop.DevReqDto;
import EFUB.homepage.dto.user.UserReqDto;
import EFUB.homepage.exception.DuplicateUserException;
import EFUB.homepage.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recruitment/")
public class ApplyController {
    private final UserService userService;
    private final ToolService toolService;
    private final DesignService designService;
    private final DevelopService developService;
    private final InterviewService interviewService;


    @PostMapping("/apply/develop")
    public ResponseEntity<Object> applyDevelop(@RequestBody UserReqDto userReqDto){
        if (userService.checkDuplicateUsers(userReqDto, Position.DEVELOPER_LEAD) || userService.checkDuplicateUsers(userReqDto, Position.DEVELOPER_INTERN))
            throw new DuplicateUserException("이미 지원하셨습니다");
        return ResponseEntity.ok(200);
    }

    @PostMapping("/apply/design")
    public ResponseEntity<Object> applyDesign(@RequestBody UserReqDto userReqDto){
        if (userService.checkDuplicateUsers(userReqDto, Position.DESIGNER))
            throw new DuplicateUserException("이미 지원하셨습니다");
        return ResponseEntity.ok(200);
    }

    @PostMapping("/submit/develop/intern")
    // TODO: dto @Valid
    public ResponseEntity<Object> submitDevelopIntern(@RequestBody DevReqDto devReqDto) {
        if (submitDevelop(devReqDto, Position.DEVELOPER_INTERN))
            return ResponseEntity.ok(200);
        return ResponseEntity.internalServerError().build();
    }

    @PostMapping("/submit/develop/lead")
    // TODO: dto @Valid
    public ResponseEntity<Object> submitDevelopLead(@RequestBody DevReqDto devReqDto) {
        if (submitDevelop(devReqDto, Position.DEVELOPER_LEAD))
            return ResponseEntity.ok(200);
        return ResponseEntity.internalServerError().build();
    }

    private Boolean submitDevelop(DevReqDto devReqDto, Position developPosition) {
        // TODO: @ControllerAdvice to error control
        User user = userService.save(devReqDto.getUser(), developPosition);

        toolService.save(user, devReqDto.getTools());
        interviewService.save(user, devReqDto.getInterviews());
        developService.save(user, devReqDto.getApply(), developPosition);

        return true;
    }

    @PostMapping("/submit/design")
    public ResponseEntity<Object> submitDesign(@RequestBody DesReqDto desReqDto){
        User user = userService.save(desReqDto.getUser(), Position.DESIGNER);

        toolService.save(user, desReqDto.getTools());
        interviewService.save(user, desReqDto.getInterviews());
        designService.save(user, desReqDto.getApply());

        return ResponseEntity.ok(200);
    }
}
