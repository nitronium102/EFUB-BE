package EFUB.homepage.service;

import EFUB.homepage.domain.Design;
import EFUB.homepage.dto.DesignDto;
import EFUB.homepage.dto.UpdateDesignDto;
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

    @Transactional
    public void update(UpdateDesignDto updateDesignDto){
        Long desId = updateDesignDto.getDes_id();
        Design design = designRepository.findById(desId).get();
        design.update(updateDesignDto.getMotive(),
                updateDesignDto.getConfidence_des(),
                updateDesignDto.getConfidence_tool(),
                updateDesignDto.getProject_topic(),
                updateDesignDto.getExp_des(),
                updateDesignDto.getExp_dev(),
                updateDesignDto.getLink(),
                updateDesignDto.getInterview(),
                updateDesignDto.getOrientation());

    }
}
