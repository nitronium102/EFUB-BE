package EFUB.homepage.service;

import EFUB.homepage.dto.MailDto;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ContactService {

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
}