package EFUB.homepage.service;

import EFUB.homepage.domain.Intern;
import EFUB.homepage.domain.User;
import EFUB.homepage.dto.develop.DevApplyDto;
import EFUB.homepage.repository.InternRepository;
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

    @Transactional
    public void save(User user, DevApplyDto apply) {
        if (apply.getApplicationField().startsWith("인턴")) {
            log.info("서비스에서 확인: " + apply.getToolName());
            internRepository.save(Intern.createIntern(user, apply));
        }
        // Todo: 리드 부분 인턴과 동일하게 개발
//        else {
//            developRepository.save(Lead.createLead(user, apply));
//        }
    }
}
