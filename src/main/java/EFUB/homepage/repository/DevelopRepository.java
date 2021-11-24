package EFUB.homepage.repository;

import EFUB.homepage.domain.Design;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopRepository extends JpaRepository<Design, Long> {
}
