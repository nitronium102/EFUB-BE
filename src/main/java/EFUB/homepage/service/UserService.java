package EFUB.homepage.service;

import EFUB.homepage.domain.User;
import EFUB.homepage.dto.UserRequestDto;
import EFUB.homepage.dto.UserResponseDto;
import EFUB.homepage.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto checkAndSaveUser(UserRequestDto userRequestDto) {
        User user = userRepository.findByNameAndPhoneNoAndPassword(
                userRequestDto.getName(),
                userRequestDto.getPhoneNo(),
                userRequestDto.getPassword()
                );

        if (user == null) { //기존에 저장되지 않은 유저
            User newUser = new User(userRequestDto.getName(),
                userRequestDto.getStudentId(),
                userRequestDto.getDepartment(),
                userRequestDto.getPhoneNo(),
                userRequestDto.getPassword(),
                null,
                null,
                false,
                userRequestDto.getPosition());
            userRepository.save(newUser); // 저장
            return new UserResponseDto(newUser); //userId랑 saveFinal 값 반환
        }

        return new UserResponseDto(user);



    }

	public boolean isSaveFinal(Long user_id) {
        Optional<User> user = userRepository.findById(user_id);
        if (user.isPresent())
            return user.get().getSaveFinal();
        return false;
	}


//
//    @Transactional
//    public Long checkUser(UserRequestDto userRequestDto) {
////        User user = new User(userRequestDto.getName(),
////                userRequestDto.getStudentId(),
////                userRequestDto.getDepartment(),
////                userRequestDto.getPhoneNo(),
////                userRequestDto.getPassword(),
////                null,
////                null,
////                false,
////                userRequestDto.getPosition())
//        if (userRepository.existsByNameAndPhoneNoAndPassword(
//                userRequestDto.getName(),
//                userRequestDto.getPhoneNo(),
//                userRequestDto.getPassword()) == false) return 0L;
//        else
//
//    }
//
//    @Transactional
//    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
//    }
//
//    @Transactional
//    public UserResponseDto searchByUserId(Long savedUser) {
//    }
}
