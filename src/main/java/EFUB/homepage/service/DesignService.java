package EFUB.homepage.service;

import EFUB.homepage.domain.Design;
import EFUB.homepage.domain.User;
import EFUB.homepage.dto.design.DesApplyDto;
import EFUB.homepage.repository.DesignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DesignService {
    private final DesignRepository designRepository;

    @Transactional
    public void save(User user, DesApplyDto apply){
        designRepository.save(Design.createDesign(user, apply));
    }
}
