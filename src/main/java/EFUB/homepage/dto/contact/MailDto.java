package EFUB.homepage.dto.contact;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MailDto {

	private String email;
	private String title;
	private String content;

	public MailDto(String email, String title, String content) {
		this.email = email;
		this.title = title;
		this.content = content;
	}
}