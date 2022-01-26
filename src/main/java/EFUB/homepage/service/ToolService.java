package EFUB.homepage.service;

import EFUB.homepage.domain.Tool;
import EFUB.homepage.domain.User;
import EFUB.homepage.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToolService {
	private final ToolRepository toolRepository;

	public void save(User user, List<String> tools) {
		tools.forEach(toolName -> toolRepository.save(Tool.createTool(user, toolName)));
	}
}
