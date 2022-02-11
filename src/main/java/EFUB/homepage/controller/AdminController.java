package EFUB.homepage.controller;

import EFUB.homepage.domain.User;
import EFUB.homepage.dto.pass.PassFinalUpdateInfo;
import EFUB.homepage.dto.pass.PassMidUpdateInfo;
import EFUB.homepage.exception.NoSuchUserException;
import EFUB.homepage.repository.UserRepository;
import EFUB.homepage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/admin")
@Controller
@RequiredArgsConstructor
public class AdminController {

	private final UserService userService;
	private final UserRepository userRepository;

	@GetMapping("/{order}/{position}")
	ResponseEntity<Object> getUsers(@PathVariable("order") String order, @PathVariable("position") String position) {
		return ResponseEntity.ok(userService.getUsers(order, position));
	}

	@PutMapping("/mid/{position}")
	ResponseEntity<Object> updatePassMid(@PathVariable("position") String position,
										 @RequestBody List<PassMidUpdateInfo> passMidInfos) {
		userService.updatePassMidInfo(position, passMidInfos);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/final/{position}")
	ResponseEntity<Object> updatePassFinal(@PathVariable("position") String position,
										   @RequestBody List<PassFinalUpdateInfo> passFinalInfos) {
		userService.updatePassFinalInfo(position, passFinalInfos);
		return ResponseEntity.ok().build();
	}

	@GetMapping("application/{position}/{id}")
	ResponseEntity<Object> getApplication(@PathVariable("position") String position, @PathVariable("id") Long id) {
		Optional<User> userOptional = userRepository.findByUserIdAndPosition(id, User.getPosition(position));
		userOptional.orElseThrow(NoSuchUserException::new);
		return ResponseEntity.ok(userService.getApplication(userOptional.get()));
	}
}
