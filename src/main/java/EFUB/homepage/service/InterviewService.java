package EFUB.homepage.service;

import EFUB.homepage.domain.Interview;
import EFUB.homepage.domain.User;
import EFUB.homepage.repository.InterviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewService {
	public final InterviewRepository interviewRepository;

	public void save(User user, List<String> interviews) {
		interviews.forEach(date -> interviewRepository.save(Interview.createInterview(user, date)));
	}
}
