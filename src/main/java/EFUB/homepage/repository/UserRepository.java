package EFUB.homepage.repository;

import EFUB.homepage.domain.Position;
import EFUB.homepage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndStudentIdAndPosition(String name, String studentId, Position position);
    Optional<User> findByNameAndPhoneNo(String name, String phoneNo);
    List<User> findAllByPosition(Position position);
    List<User> findAllByPositionAndPassMid(Position position, Boolean order);
    Optional<User> findByUserIdAndPosition(Long userId, Position position);
	Optional<User> findByUserIdAndPositionAndPassMid(Long userId, Position position, boolean b);
}
