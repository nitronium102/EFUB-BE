package EFUB.homepage.service;

import EFUB.homepage.domain.*;
import EFUB.homepage.dto.application.ApplyResDto;
import EFUB.homepage.dto.design.DesResDto;
import EFUB.homepage.dto.develop.DevInternResDto;
import EFUB.homepage.dto.develop.DevLeadResDto;
import EFUB.homepage.dto.pass.PassFinalUpdateInfo;
import EFUB.homepage.dto.pass.PassMidUpdateInfo;
import EFUB.homepage.dto.pass.PassResDto;
import EFUB.homepage.dto.user.UserReqDto;
import EFUB.homepage.dto.user.UserResDto;
import EFUB.homepage.exception.NotPassMidException;
import EFUB.homepage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

	public Boolean checkDuplicateUsers(UserReqDto userReqDto, Position position) {
		User user = userRepository.findByNameAndStudentIdAndPosition(
				userReqDto.getName(),
				userReqDto.getStudentId(),
				position
		);
		return user != null;
	}

	public PassResDto getUsers(String strOrder, String strPosition) {
		List<User> users = getUserListByOrderAndPosition(strOrder, strPosition);
		Position position = User.getPosition(strPosition);
		List<UserResDto> userResDtos = Collections.emptyList();
		if (!users.isEmpty())
			userResDtos = users.stream().map(User::toUserResDto).collect(Collectors.toList());

		return PassResDto.builder().users(userResDtos).count(userResDtos.stream().count()).build();
	}

	public List<User> getUserListByOrderAndPosition(String strOrder, String strPosition) {
		Position position = User.getPosition(strPosition);
		if (strOrder.equals("final")) {
			Boolean order = true;
			return userRepository.findAllByPositionAndPassMid(position, order);
		}
		return userRepository.findAllByPosition(position);
	}

	@Transactional
	public void updatePassMidInfo(String strPosition, List<PassMidUpdateInfo> passMidInfos) {
		Position position = User.getPosition(strPosition);
		for (PassMidUpdateInfo userPassInfo : passMidInfos) {
			Optional<User> optionalUser = userRepository.findByUserIdAndPosition(userPassInfo.getUserId(), position);
			optionalUser.ifPresent(user -> user.updatePassMid(userPassInfo.getPassMid()));
		}
	}

	@Transactional
	public void updatePassFinalInfo(String strPosition, List<PassFinalUpdateInfo> passFinalInfos) {
		Position position = User.getPosition(strPosition);
		List<Long> notPassMidUserIds = new ArrayList<>();
		for (PassFinalUpdateInfo userPassInfo : passFinalInfos) {
			Optional<User> optionalUser = userRepository
					.findByUserIdAndPositionAndPassMid(userPassInfo.getUserId(), position, true);
			if (optionalUser.isEmpty()) {
				notPassMidUserIds.add(userPassInfo.getUserId());
				continue;
			}
			optionalUser.get().updatePassFinal(userPassInfo.getPassFinal());
		}
		if (!notPassMidUserIds.isEmpty())
			throw new NotPassMidException(notPassMidUserIds);
	}

	public ApplyResDto getApplication(User user) {
		Object application;
		switch (user.getPosition()) {
			case DEVELOPER_INTERN:
				application = getInternApplication(user);
				break;
			case DEVELOPER_LEAD:
				application = getLeadApplication(user);
				break;
			default:
			case DESIGNER:
				application = getDesignApplication(user);
		}
		return ApplyResDto.builder()
				.user(user.toUserResDto())
				.apply(application)
				.build();
	}

	private DevInternResDto getInternApplication(User user) {
		Intern intern = user.getDevelopIntern();
		return DevInternResDto.builder()
				.applicationField(intern.getApplicationField())
				.confidenceLang(intern.getConfidenceLang())
				.developId(intern.getDevelopId())
				.expProject(intern.getProjectTopic())
				.expStudy(intern.getExpStudy())
				.language(intern.getLanguage())
				.link(intern.getLink())
				.motive(intern.getMotive())
				.orientation(intern.getOrientation())
				.projectTopic(intern.getProjectTopic())
				.tools(user.getTools().stream().map(User::toToolResDto).collect(Collectors.toList()))
				.interviews(user.getInterviews().stream().map(User::toInterviewResDto).collect(Collectors.toList()))
				.build();
	}

	private DevLeadResDto getLeadApplication(User user) {
		Lead lead  = user.getDevelopLead();
		return DevLeadResDto.builder()
				.applicationField(lead.getApplicationField())
				.confidenceLang(lead.getConfidenceLang())
				.developId(lead.getDevelopId())
				.expSolve(lead.getExpSolve())
				.seminarTopic(lead.getSeminarTopic())
				.interviews(user.getInterviews().stream().map(User::toInterviewResDto).collect(Collectors.toList()))
				.language(lead.getLanguage())
				.link(lead.getLink())
				.motive(lead.getMotive())
				.orientation(lead.getOrientation())
				.projectTopic(lead.getProjectTopic())
				.tools(user.getTools().stream().map(User::toToolResDto).collect(Collectors.toList()))
				.build();
	}

	private DesResDto getDesignApplication(User user) {
		Design design = user.getDesign();
		return DesResDto.builder()
				.designId(design.getDesignId())
				.activityPlan(design.getActivityPlan())
				.confidenceTool(design.getConfidenceTool())
				.expSolve(design.getExpSolve())
				.interviews(user.getInterviews().stream().map(User::toInterviewResDto).collect(Collectors.toList()))
				.link(design.getLink())
				.motive(design.getMotive())
				.orientation(design.getOrientation())
				.tools(user.getTools().stream().map(User::toToolResDto).collect(Collectors.toList()))
				.motive(design.getMotive())
				.build();
	}
}
