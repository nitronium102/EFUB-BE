package EFUB.homepage.service;

import EFUB.homepage.domain.User;
import EFUB.homepage.dto.PassDto;
import EFUB.homepage.dto.PassResponseDto;
import EFUB.homepage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PassService {
	private final UserRepository userRepository;

	public PassResponseDto checkMidPass(PassDto passDto){

		User user = userRepository.findByNameAndPhoneNoAndPassword(
			passDto.getName(),
			passDto.getPhoneNo(),
			passDto.getPassword()
		);

		Boolean isPass;
		String result;

		if (user != null){
			isPass = user.getPassMid();
		} else {
			result = "잘못된 정보입니다.";
			return new PassResponseDto(result);
		}

		if (isPass)
			result = "합격";
		else
			result = "불합격";

		return new PassResponseDto(result);
	}

	public PassResponseDto checkFinPass(PassDto passDto){

		User user = userRepository.findByNameAndPhoneNoAndPassword(
			passDto.getName(),
			passDto.getPhoneNo(),
			passDto.getPassword()
		);

		Boolean isPass;
		String result;

		if (user != null){
			isPass = user.getPassFinal();
		} else {
			result = "잘못된 정보입니다.";
			return new PassResponseDto(result);
		}

		if (isPass)
			result = "합격";
		else
			result = "불합격";

		return new PassResponseDto(result);
	}
}
