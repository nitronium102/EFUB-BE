package EFUB.homepage.service;

import EFUB.homepage.domain.User;
import EFUB.homepage.dto.pass.PassDto;
import EFUB.homepage.dto.pass.PassResDto;
import EFUB.homepage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;


@RequiredArgsConstructor
@Service
public class PassService {
	private final UserRepository userRepository;

	public PassResDto checkMidPass(PassDto passDto) {

		User user = userRepository.findByNameAndPhoneNo(
			passDto.getName(),
			passDto.getPhoneNo()
		);

		Boolean isPass;
		String result;

		if (user == null) { // 등록된 유저가 없는 경우
			return new PassResDto("잘못된 정보입니다.");
		}
		if (!Objects.equals(user.getPassword(), passDto.getPassword())) {
			return new PassResDto("비밀번호가 틀립니다.");
		}

		isPass = user.getPassMid();
		if (isPass)
			result = "합격";
		else
			result = "불합격";

		return new PassResDto(result);
	}

	public PassResDto checkFinPass(PassDto passDto) {

		User user = userRepository.findByNameAndPhoneNo(
			passDto.getName(),
			passDto.getPhoneNo()
		);

		Boolean isPass;
		String result;

		if (user == null) { // 등록된 유저가 없는 경우
			return new PassResDto("잘못된 정보입니다.");
		}
		if (!Objects.equals(user.getPassword(), passDto.getPassword())) {
			return new PassResDto("비밀번호가 틀립니다.");
		}

		isPass = user.getPassFinal();
		if (isPass)
			result = "합격";
		else
			result = "불합격";

		return new PassResDto(result);
	}
}
