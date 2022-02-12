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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {
    private final AdminRepository repository;

    @Transactional
    public Optional<Admin> findUser(LoginReqDto loginReqDto) {
        return repository.findByAdminId(loginReqDto.getAdminId());
    }

    @Override
    public AdminDetail loadUserByUsername(String adminId) {
        return repository.findByAdminId(adminId).map(Admin::toAdminDetail)
                .orElseThrow(() -> new UsernameNotFoundException("유저 id를 찾을 수 없습니다"));
    }
}
