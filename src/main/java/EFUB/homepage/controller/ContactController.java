package EFUB.homepage.controller;

import EFUB.homepage.dto.ContactDto;
import EFUB.homepage.dto.MailDto;
import EFUB.homepage.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ContactController {

	public final ContactService contactService;

	@PostMapping("/contact")
	public void sendMail(@RequestBody ContactDto contactDto) {
		String email = contactDto.getWriter_email();
		String title = "[EFUB 문의]";
		String content = contactDto.getContent();

		MailDto mailDto = new MailDto(email, title, content);
		contactService.mailSend(mailDto);
	}
}