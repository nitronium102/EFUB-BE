package EFUB.homepage.repository;

import EFUB.homepage.domain.Design;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DesignRepository extends JpaRepository<Design, Long> {
	Optional<Design> findByUserId(Long user_id);
}
