package EFUB.homepage.service;

import EFUB.homepage.domain.Design;
import EFUB.homepage.dto.DesignDto;
import EFUB.homepage.repository.DesignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class DesignService {
    private final DesignRepository designRepository;

    @Transactional
    public Design save(DesignDto designDto){
        return designRepository.save(designDto.toEntity());
    }
}
