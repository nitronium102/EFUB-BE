package EFUB.homepage.service;

import EFUB.homepage.domain.Interview;
import EFUB.homepage.dto.InterviewDto;
import EFUB.homepage.repository.InterviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class InterviewService {
    private final InterviewRepository interviewRepository;

    @Transactional
    public Interview save(InterviewDto interviewDto){
        return interviewRepository.save(interviewDto.toEntity());
    }
}
