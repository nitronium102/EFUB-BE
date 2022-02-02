package EFUB.homepage.service;

import EFUB.homepage.domain.Position;
import EFUB.homepage.domain.User;
import EFUB.homepage.dto.common.PassReqDto;
import EFUB.homepage.dto.common.PassResDto;
import EFUB.homepage.dto.common.UserReqDto;
import EFUB.homepage.dto.common.UserResDto;
import EFUB.homepage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public User save(UserReqDto user, Position position) {
		return userRepository.save(user.toEntity(user, position));
	}

	public PassResDto getUsers(String strOrder, String strPosition) {
		log.info("[*] order = " + strOrder);
		log.info("[*] position = " + strPosition);

		List<User> users = getUserListByOrderAndPosition(strOrder, strPosition);
		List<UserResDto> userResDtos = Collections.emptyList();
		if (!users.isEmpty())
			userResDtos = users.stream().map(User::toUserResDto).collect(Collectors.toList());

		return PassResDto.builder().users(userResDtos).count(userResDtos.stream().count()).build();
	}

	public List<User> getUserListByOrderAndPosition(String strOrder, String strPosition) {


		Position position;
		switch (strPosition) {
			case "intern":
				position = Position.DEVELOPER_INTERN;
				break;
			case "lead":
				position = Position.DEVELOPER_LEAD;
				break;
			case "design": default:
				position = Position.DESIGNER;
		}

		if (strOrder.equals("final")) {
			Boolean order = true;
			return userRepository.findAllByPositionAndPassMid(position, order);
		} return userRepository.findAllByPosition(position);
	}
}
