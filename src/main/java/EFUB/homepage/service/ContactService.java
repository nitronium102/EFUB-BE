package EFUB.homepage.service;

import EFUB.homepage.domain.Contact;
import EFUB.homepage.dto.ContactDto;
import EFUB.homepage.dto.MailDto;
import EFUB.homepage.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class ContactService {
	private final ContactRepository contactRepository;

	private JavaMailSender mailSender;
	private static final String TO_ADDRESS = "ewhaefub@gmail.com";

	public void mailSend(MailDto mailDto) {
		try {
			MailHandler mailHandler = new MailHandler(mailSender);
			mailHandler.setTo(ContactService.TO_ADDRESS);
			mailHandler.setFrom(mailDto.getEmail());
			mailHandler.setSubject("[EFUB 문의 메일]");
			String htmlContent = "<p>" + mailDto.getContent() + "<p>" + mailDto.getEmail() + "<p>";
			mailHandler.setText(htmlContent, true);
			mailHandler.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public Contact saveContact(ContactDto contactDto) {
		return contactRepository.save(contactDto.toEntity());
	}

	@Transactional
	public Contact findByContactId(Long contactId) {
		Contact contact = contactRepository.findByContactId(contactId);
		return contact;
	}
}