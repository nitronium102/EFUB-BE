package EFUB.homepage.service;

import EFUB.homepage.domain.Develop;
import EFUB.homepage.dto.DevelopDto;
import EFUB.homepage.dto.UpdateDevelopDto;
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

    @Transactional
    public void update(UpdateDevelopDto updateDevelopDto) {
        Long devId = updateDevelopDto.getDev_id();
        Develop develop = developRepository.findById(devId).get();
        develop.update(updateDevelopDto.getMotive(),
                updateDevelopDto.getProject_topic(),
                updateDevelopDto.getApplication_field(),
                updateDevelopDto.getLanguage(),
                updateDevelopDto.getConfidence_lang(),
                updateDevelopDto.getExp(),
                updateDevelopDto.getLink(),
                updateDevelopDto.getOrientation());
    }
}
