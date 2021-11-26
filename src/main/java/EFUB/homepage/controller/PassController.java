package EFUB.homepage.controller;

import EFUB.homepage.dto.PassDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recruitment/pass")
public class PassController {

	@PostMapping("/mid")
	public ResponseEntity checkMidPass(@RequestBody PassDto passDto){
		// TODO : User의 pass_mid 값 받아오기
	}

	@PostMapping("/final")
	public ResponseEntity checkFinPass(@RequestBody PassDto passDto){
		// TODO : User의 pass_final 값 받아오기
	}
}
