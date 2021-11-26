package EFUB.homepage.repository;

import EFUB.homepage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Boolean existsByNameAndPhoneNoAndPassword(String name, String phoneNo, String password);
    User findByNameAndPhoneNoAndPassword(String name, String phoneNo, String password);

}
