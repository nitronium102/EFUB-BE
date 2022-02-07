package EFUB.homepage.service;

import EFUB.homepage.domain.Intern;
import EFUB.homepage.domain.Lead;
import EFUB.homepage.domain.Position;
import EFUB.homepage.domain.User;
import EFUB.homepage.dto.develop.DevApplyDto;
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

	@Transactional
	public void save(User user, DevApplyDto apply, Position developPosition) {
		if (developPosition == Position.DEVELOPER_INTERN) {
			internRepository.save(Intern.createIntern(user, apply));
		} else if (developPosition == Position.DEVELOPER_LEAD) {
			leadRepository.save(Lead.createLead(user, apply));
		}
	}
}
