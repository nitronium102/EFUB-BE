package EFUB.homepage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/")
	public String serverTest() {
		return "EFUB Server is working now!❤️‍🔥";
	}
}
