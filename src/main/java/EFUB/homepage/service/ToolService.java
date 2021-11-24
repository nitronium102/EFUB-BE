package EFUB.homepage.service;

import EFUB.homepage.domain.Tool;
import EFUB.homepage.dto.ToolDto;
import EFUB.homepage.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ToolService {
    private final ToolRepository toolRepository;

    @Transactional
    public Tool save(ToolDto toolDto){
        return toolRepository.save(toolDto.toEntity());
    }
}
