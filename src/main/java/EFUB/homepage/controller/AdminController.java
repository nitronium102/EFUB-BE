package EFUB.homepage.controller;

import EFUB.homepage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
@RequiredArgsConstructor
public class AdminController {

	private final UserService userService;

	@GetMapping("/{order}/{position}")
	ResponseEntity<Object> getUsers(@PathVariable("order") String order, @PathVariable("position") String position) {
		return ResponseEntity.ok(userService.getUsers(order, position));
	}
}
