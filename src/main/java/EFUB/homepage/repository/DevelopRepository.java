package EFUB.homepage.repository;

import EFUB.homepage.domain.Develop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DevelopRepository extends JpaRepository<Develop, Long> {
	Optional<Develop> findByUserId(Long user_id);
}
