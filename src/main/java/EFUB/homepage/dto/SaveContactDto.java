package EFUB.homepage.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SaveContactDto {
	private Long contact_id;
	private String writer_email;
	private String content;

	@Builder
	public SaveContactDto(Long contact_id, String writer_email, String content){
		this.contact_id = contact_id;
		this.writer_email = writer_email;
		this.content = content;
	}
}
