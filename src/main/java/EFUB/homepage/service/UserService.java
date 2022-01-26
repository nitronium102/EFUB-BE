package EFUB.homepage.service;

import EFUB.homepage.domain.Position;
import EFUB.homepage.domain.User;
import EFUB.homepage.dto.common.UserReqDto;
import EFUB.homepage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public User save(UserReqDto user, Position position) {
		return userRepository.save(
				User.builder()
						.name(user.getName())
						.password(user.getPassword())
						.phoneNo(user.getPhoneNo())
						.studentId(user.getStudentId())
						.department(user.getDepartment())
						.position(position)
						.build());
	}
}
