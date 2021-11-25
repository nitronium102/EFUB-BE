package EFUB.homepage.dto;

import EFUB.homepage.domain.Contact;
import EFUB.homepage.domain.Interview;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ContactDto {
	private Long contact_id;
	private String writer_email;
	private String content;

	@Builder
	public ContactDto(Long contact_id, String writer_email, String content){
		this.contact_id = contact_id;
		this.writer_email = writer_email;
		this.content = content;
	}

	public Contact toEntity(){
		return Contact.builder()
			.contactId(this.contact_id)
			.writerEmail(this.writer_email)
			.content(this.content)
			.build();
	}

}
