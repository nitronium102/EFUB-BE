package EFUB.homepage.service;

import EFUB.homepage.domain.Tool;
import EFUB.homepage.dto.ToolDto;
import EFUB.homepage.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ToolService {
    private final ToolRepository toolRepository;

    @Transactional
    public Tool save(ToolDto toolDto){
        return toolRepository.save(toolDto.toEntity());
    }

    @Transactional
    public List<Tool> findByUserId(Long userId){
        List<Tool> tooList = toolRepository.findByUserId(userId);
        return tooList;
    }

    @Transactional
    public void delete(Long toolId){
        toolRepository.deleteById(toolId);
    }
}
