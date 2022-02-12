package EFUB.homepage.controller;

import EFUB.homepage.config.JwtTokenProvider;
import EFUB.homepage.domain.Admin;
import EFUB.homepage.dto.login.LoginReqDto;
import EFUB.homepage.exception.NoSuchAdminException;
import EFUB.homepage.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class LoginController {
    private final LoginService service;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginReqDto loginReqDto) {
        Optional<Admin> optionalAdmin = service.findUser(loginReqDto);
        if(optionalAdmin.isEmpty()) throw new NoSuchAdminException("잘못된 아이디입니다.");
        Admin admin = optionalAdmin.get();
        if(!passwordEncoder.matches(loginReqDto.getPassword(), admin.getPassword())) {
            throw new NoSuchAdminException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(admin.getAdminId(), admin.getRole());
    }
}
