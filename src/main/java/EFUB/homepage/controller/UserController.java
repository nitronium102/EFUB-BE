package EFUB.homepage.controller;


import EFUB.homepage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

//    @PostMapping("/api/recruitment/apply/user")
//    public UserResponseDto checkAndSaveUser(@RequestBody UserReqDto userReqDto){
//        return userService.checkAndSaveUser(userReqDto);
//    }

}
