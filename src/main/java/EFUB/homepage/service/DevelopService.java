package EFUB.homepage.service;

import EFUB.homepage.domain.Develop;
import EFUB.homepage.domain.Interview;
import EFUB.homepage.domain.Tool;
import EFUB.homepage.dto.*;
import EFUB.homepage.repository.DevelopRepository;
import EFUB.homepage.repository.InterviewRepository;
import EFUB.homepage.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DevelopService {
    private final DevelopRepository developRepository;
    private final ToolRepository toolRepository;
    private final InterviewRepository interviewRepository;

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

    @Transactional(readOnly = true)
    public DevelopResDto getDevelop(Long user_id) {
        Optional<Develop> develop = developRepository.findByUserId(user_id);
        if (develop.isEmpty())
            return (new Develop()).toDevelopResDto(null, null);

        List<ToolResDto> tools = toolRepository.findByUserId(user_id)
            .stream().map(Tool::toToolResDto).collect(Collectors.toList());
        List<InterviewResDto> interviews = interviewRepository.findByUserId(user_id)
            .stream().map(Interview::toInterviewResDto).collect(Collectors.toList());
        return develop.get().toDevelopResDto(tools, interviews);
    }
}
