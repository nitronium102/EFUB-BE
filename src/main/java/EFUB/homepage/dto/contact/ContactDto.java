package EFUB.homepage.dto.contact;

import EFUB.homepage.domain.Contact;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ContactDto {
	private Long contactId;
	private String writerEmail;
	private String content;

	@Builder
	public ContactDto(Long contactId, String writerEmail, String content) {
		this.contactId = contactId;
		this.writerEmail = writerEmail;
		this.content = content;
	}

	public Contact toEntity() {
		return Contact.builder()
				.contactId(this.contactId)
				.writerEmail(this.writerEmail)
				.content(this.content)
				.build();
	}

}