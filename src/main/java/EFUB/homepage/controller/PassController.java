package EFUB.homepage.controller;

import EFUB.homepage.dto.PassDto;
import EFUB.homepage.dto.PassResponseDto;
import EFUB.homepage.service.PassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recruitment/pass")
public class PassController {

	private final PassService passService;

	@PostMapping("/mid")
	public PassResponseDto checkMidPass(@RequestBody PassDto passDto) {
		return passService.checkMidPass(passDto);
	}

	@PostMapping("/final")
	public PassResponseDto checkFinPass(@RequestBody PassDto passDto) {
		return passService.checkFinPass(passDto);
	}
}
