package EFUB.homepage.service;

import EFUB.homepage.dto.contact.ContactDto;
import EFUB.homepage.dto.contact.MailDto;
import EFUB.homepage.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
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

	public void saveContact(ContactDto contactDto) {
		contactRepository.save(contactDto.toEntity());
	}
}