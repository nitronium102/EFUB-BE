package EFUB.homepage.repository;

import EFUB.homepage.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	Contact findByContactId(Long contactId);
}