package EFUB.homepage.service;

import EFUB.homepage.domain.Develop;
import EFUB.homepage.dto.DevelopDto;
import EFUB.homepage.repository.DevelopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class DevelopService {
    private final DevelopRepository developRepository;

    @Transactional
    public Develop save(DevelopDto developDto){
        return developRepository.save(developDto.toEntity());
    }
}
