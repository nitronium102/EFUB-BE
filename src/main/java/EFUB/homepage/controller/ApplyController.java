package EFUB.homepage.controller;

import EFUB.homepage.domain.Position;
import EFUB.homepage.domain.User;
import EFUB.homepage.dto.design.DesReqDto;
import EFUB.homepage.dto.develop.DevInternReqDto;
import EFUB.homepage.dto.develop.DevLeadReqDto;
import EFUB.homepage.dto.user.UserReqDto;
import EFUB.homepage.exception.DuplicateUserException;
import EFUB.homepage.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recruitment")
public class ApplyController {
    private final UserService userService;
    private final ToolService toolService;
    private final DesignService designService;
    private final DevelopService developService;
    private final InterviewService interviewService;


    @PostMapping("/check/develop")
    public ResponseEntity<Object> checkDevelop(@RequestBody UserReqDto userReqDto){
        if (userService.checkDuplicateUsers(userReqDto, Position.DEVELOPER_LEAD) || userService.checkDuplicateUsers(userReqDto, Position.DEVELOPER_INTERN))
            throw new DuplicateUserException();
        return ResponseEntity.ok(200);
    }

    @PostMapping("/check/design")
    public ResponseEntity<Object> checkDesign(@RequestBody UserReqDto userReqDto){
        if (userService.checkDuplicateUsers(userReqDto, Position.DESIGNER))
            throw new DuplicateUserException();
        return ResponseEntity.ok(200);
    }

	@PostMapping("/submit/develop/intern")
	public ResponseEntity<Object> submitDevelopIntern(@Valid @RequestBody DevInternReqDto devInternReqDto) {
		Long userId = developService.submitIntern(devInternReqDto, Position.DEVELOPER_INTERN);
		return ResponseEntity.created(URI.create("intern/" + userId.toString())).build();
	}

	@PostMapping("/submit/develop/lead")
	public ResponseEntity<Object> submitDevelopLead(@Valid @RequestBody DevLeadReqDto devLeadReqDto) {
		Long userId = developService.submitLead(devLeadReqDto, Position.DEVELOPER_LEAD);
		return ResponseEntity.created(URI.create("lead/" + userId.toString())).build();
	}

	@PostMapping("/submit/design")
	public ResponseEntity<Object> submitDesign(@Valid @RequestBody DesReqDto desReqDto) {
		User user = userService.save(desReqDto.getUser(), Position.DESIGNER);

		toolService.save(user, desReqDto.getTools());
		interviewService.save(user, desReqDto.getInterviews());
		designService.save(user, desReqDto.getApply());

		return ResponseEntity.created(URI.create("design/" + user.getUserId().toString())).build();
	}
}
