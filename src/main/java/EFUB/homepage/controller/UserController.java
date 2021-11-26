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
//        Long savedUser = 0L;
//        savedUser = userService.checkUser(userRequestDto);
//
//        if (savedUser == 0) return userService.saveUser(userRequestDto);
//
//        else return userService.searchByUserId(savedUser);
        return userService.checkAndSaveUser(userRequestDto);


    }


}
