package EFUB.homepage.repository;

import EFUB.homepage.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	List<Contact> findByContactId(Long contactId);
}
