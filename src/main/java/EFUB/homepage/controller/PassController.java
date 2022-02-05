package EFUB.homepage.controller;

import EFUB.homepage.dto.pass.PassDto;
import EFUB.homepage.dto.pass.PassResultResDto;
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
	public PassResultResDto checkMidPass(@RequestBody PassDto passDto) {
		return passService.checkMidPass(passDto);
	}

	@PostMapping("/final")
	public PassResultResDto checkFinPass(@RequestBody PassDto passDto) {
		return passService.checkFinPass(passDto);
	}
}
