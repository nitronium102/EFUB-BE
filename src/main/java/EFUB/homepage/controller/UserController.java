package EFUB.homepage.controller;


import EFUB.homepage.dto.UserRequestDto;
import EFUB.homepage.dto.UserResponseDto;
import EFUB.homepage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/recruitment/apply/user")
    public UserResponseDto checkAndSaveUser(@RequestBody UserRequestDto userRequestDto){
        return userService.checkAndSaveUser(userRequestDto);
    }


}
