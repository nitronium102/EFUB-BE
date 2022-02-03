package EFUB.homepage.controller;

import EFUB.homepage.dto.pass.PassFinalUpdateInfo;
import EFUB.homepage.dto.pass.PassMidUpdateInfo;
import EFUB.homepage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin")
@Controller
@RequiredArgsConstructor
public class AdminController {

	private final UserService userService;

	@GetMapping("/{order}/{position}")
	ResponseEntity<Object> getUsers(@PathVariable("order") String order, @PathVariable("position") String position) {
		return ResponseEntity.ok(userService.getUsers(order, position));
	}

	@PutMapping("/mid/{position}")
	ResponseEntity<Object> udpatePassMid(@PathVariable("position") String position,
									   @RequestBody List<PassMidUpdateInfo> passMidInfos) {
		userService.updatePassMidInfo(position, passMidInfos);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/final/{position}")
	ResponseEntity<Object> udpatePassFinal(@PathVariable("position") String position,
									   @RequestBody List<PassFinalUpdateInfo> passFinalInfos) {
		userService.updatePassFinalInfo(position, passFinalInfos);
		return ResponseEntity.ok().build();
	}
}
