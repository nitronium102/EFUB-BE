package EFUB.homepage.service;

import EFUB.homepage.domain.Intern;
import EFUB.homepage.domain.Lead;
import EFUB.homepage.domain.Position;
import EFUB.homepage.domain.User;
import EFUB.homepage.dto.develop.DevInternApplyDto;
import EFUB.homepage.dto.develop.DevInternReqDto;
import EFUB.homepage.dto.develop.DevLeadApplyDto;
import EFUB.homepage.dto.develop.DevLeadReqDto;
import EFUB.homepage.exception.SaveFailureException;
import EFUB.homepage.repository.InternRepository;
import EFUB.homepage.repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class DevelopService {
	private final InternRepository internRepository;
	private final LeadRepository leadRepository;

	private final ToolService toolService;
	private final UserService userService;
	private final InterviewService interviewService;

	@Transactional
	public void saveLead(User user, DevLeadApplyDto apply) {
			leadRepository.save(Lead.createLead(user, apply));
	}

	@Transactional
	public void saveIntern(User user, DevInternApplyDto apply) {
		internRepository.save(Intern.createIntern(user, apply));
	}

	@Transactional
	public Long submitIntern(DevInternReqDto internReqDto, Position developerIntern) throws SaveFailureException {
		User user = userService.save(internReqDto.getUser(), developerIntern);
		toolService.save(user, internReqDto.getTools());
		interviewService.save(user, internReqDto.getInterviews());
		saveIntern(user, internReqDto.getApply());
		return user.getUserId();
	}

	@Transactional
	public Long submitLead(DevLeadReqDto leadReqDto, Position developerLead) throws SaveFailureException {
		User user = userService.save(leadReqDto.getUser(), developerLead);
		toolService.save(user, leadReqDto.getTools());
		interviewService.save(user, leadReqDto.getInterviews());
		saveLead(user, leadReqDto.getApply());
		return user.getUserId();
	}
}
