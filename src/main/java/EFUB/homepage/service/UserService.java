package EFUB.homepage.service;

import EFUB.homepage.domain.Position;
import EFUB.homepage.domain.User;
import EFUB.homepage.dto.pass.PassResDto;
import EFUB.homepage.dto.user.UserReqDto;
import EFUB.homepage.dto.user.UserResDto;
import EFUB.homepage.dto.pass.PassFinalUpdateInfo;
import EFUB.homepage.dto.pass.PassMidUpdateInfo;
import EFUB.homepage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
		List<User> users = getUserListByOrderAndPosition(strOrder, strPosition);
		List<UserResDto> userResDtos = Collections.emptyList();
		if (!users.isEmpty())
			userResDtos = users.stream().map(User::toUserResDto).collect(Collectors.toList());

		return PassResDto.builder().users(userResDtos).count(userResDtos.stream().count()).build();
	}

	public List<User> getUserListByOrderAndPosition(String strOrder, String strPosition) {
		Position position = getPosition(strPosition);
		if (strOrder.equals("final")) {
			Boolean order = true;
			return userRepository.findAllByPositionAndPassMid(position, order);
		}
		return userRepository.findAllByPosition(position);
	}

	@Transactional
	public void updatePassMidInfo(String strPosition, List<PassMidUpdateInfo> passMidInfos) {
		Position position = getPosition(strPosition);
		for (PassMidUpdateInfo userPassInfo : passMidInfos) {
			Optional<User> optionalUser = userRepository.findByUserIdAndPosition(userPassInfo.getUserId(), position);
			optionalUser.ifPresent(user -> user.updatePassMid(userPassInfo.getPassMid()));
		}
	}

	@Transactional
	public void updatePassFinalInfo(String strPosition, List<PassFinalUpdateInfo> passFinalInfos) {
		Position position = getPosition(strPosition);
		for (PassFinalUpdateInfo userPassInfo : passFinalInfos) {
			Optional<User> optionalUser = userRepository.findByUserIdAndPosition(userPassInfo.getUserId(), position);
			optionalUser.ifPresent(user -> user.updatePassFinal(userPassInfo.getPassFinal()));
		}
	}

	private Position getPosition(String strPosition) {
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
		return position;
	}
}
