package EFUB.homepage.service;

import EFUB.homepage.config.AdminDetail;
import EFUB.homepage.domain.Admin;
import EFUB.homepage.dto.login.LoginReqDto;
import EFUB.homepage.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {
    private final AdminRepository repository;

    @Transactional
    public Long joinUser(LoginReqDto user) {
        Admin newUser = Admin.builder()
            .adminId(user.getAdminId())
            .password(user.getPassword())
            .build();
        repository.save(newUser);
        return newUser.getAdminNum();
    }

    @Transactional
    public Admin findUser(LoginReqDto dto) {
        Admin member = repository.findByAdminId(dto.getAdminId());
        return member;
    }

    @Override
    public AdminDetail loadUserByUsername(String adminId) throws UsernameNotFoundException {
        Admin admin = repository.findByAdminId(adminId);
        return new AdminDetail(admin);
    }
}
