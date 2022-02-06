package EFUB.homepage.dto.contact;

import EFUB.homepage.domain.Contact;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ContactDto {
	private String writerEmail;
	private String content;

	public Contact toEntity() {
		return Contact.builder()
				.writerEmail(this.writerEmail)
				.content(this.content)
				.build();
	}
}