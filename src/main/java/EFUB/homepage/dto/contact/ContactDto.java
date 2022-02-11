package EFUB.homepage.dto.contact;

import EFUB.homepage.domain.Contact;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class ContactDto {
	@NotBlank
	private String writerEmail;
	@NotBlank
	private String content;

	public Contact toEntity() {
		return Contact.builder()
				.writerEmail(this.writerEmail)
				.content(this.content)
				.build();
	}
}