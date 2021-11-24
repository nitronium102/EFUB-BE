package EFUB.homepage.repository;

import EFUB.homepage.domain.Develop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopRepository extends JpaRepository<Develop, Long> {
}
