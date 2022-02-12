package EFUB.homepage.service;

import EFUB.homepage.domain.User;
import EFUB.homepage.dto.pass.PassDto;
import EFUB.homepage.dto.pass.PassResultResDto;
import EFUB.homepage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class PassService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public PassResultResDto checkMidPass(PassDto passDto) {
		Optional<User> optionalUser = userRepository.findByNameAndPhoneNo(
				passDto.getName(),
				passDto.getPhoneNo()
		);

		if (optionalUser.isEmpty()) { // 등록된 유저가 없는 경우
			return PassResultResDto.builder().result("잘못된 정보입니다.").build();
		} else {
			User user = optionalUser.get();
			if (!passwordEncoder.matches(passDto.getPassword(), user.getPassword())) {
				return PassResultResDto.builder().result("비밀번호가 틀립니다.").build();
			} else {
				return PassResultResDto.builder().result(getPassResult(user.getPassMid())).build();
			}
		}
	}

	public PassResultResDto checkFinPass(PassDto passDto) {
		Optional<User> optionalUser = userRepository.findByNameAndPhoneNo(
				passDto.getName(),
				passDto.getPhoneNo()
		);

		if (optionalUser.isEmpty()) { // 등록된 유저가 없는 경우
			return PassResultResDto.builder().result("잘못된 정보입니다.").build();
		} else {
			User user = optionalUser.get();
			if (!passwordEncoder.matches(passDto.getPassword(), user.getPassword())) {
				return PassResultResDto.builder().result("비밀번호가 틀립니다.").build();
			} else {
				return PassResultResDto.builder().result(getPassResult(user.getPassFinal())).build();
			}
		}
	}

	private String getPassResult(Boolean passMid) {
		return passMid ? "합격" : "불합격";
	}
}
