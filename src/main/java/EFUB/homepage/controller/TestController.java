package EFUB.homepage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/hello")
	public String serverTest() {
		return "efub❤️💛💚‍️\nServer is working now!❤️‍🔥";
	}
}
