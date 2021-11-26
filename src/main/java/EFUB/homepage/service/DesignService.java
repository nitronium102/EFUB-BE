package EFUB.homepage.service;

import EFUB.homepage.domain.Design;
import EFUB.homepage.domain.Tool;
import EFUB.homepage.dto.DesignDto;
import EFUB.homepage.dto.DesignResDto;
import EFUB.homepage.dto.ToolResDto;
import EFUB.homepage.dto.UpdateDesignDto;
import EFUB.homepage.repository.DesignRepository;
import EFUB.homepage.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DesignService {
    private final DesignRepository designRepository;
    private final ToolRepository toolRepository;

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

    @Transactional(readOnly = true)
	public DesignResDto getDesign(Long user_id) {
        Optional<Design> design = designRepository.findByUserId(user_id);
        if (design.isEmpty())
            return (new Design()).toDesignResDto(null);

        List<ToolResDto> tools = toolRepository.findByUserId(user_id)
            .stream().map(Tool::toToolResDto).collect(Collectors.toList());
        return design.get().toDesignResDto(tools);
	}
}
