package EFUB.homepage.controller;

import EFUB.homepage.dto.contact.ContactDto;
import EFUB.homepage.dto.contact.MailDto;
import EFUB.homepage.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> sendMail(@RequestBody ContactDto contactDto) {
		MailDto mailDto = MailDto.builder()
				.email(contactDto.getWriterEmail())
				.title("[EFUB 문의]")
				.content(contactDto.getContent())
				.build();

		contactService.mailSend(mailDto);
		contactService.saveContact(contactDto);

		return ResponseEntity.ok(200);
	}
}