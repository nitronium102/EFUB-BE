package EFUB.homepage.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name="Contact")
@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="contact_id", nullable = false)
	private Long contactId;

	@Column(name="writer_email", columnDefinition = "TEXT", nullable = false)
	private String writerEmail;

	@Column(name="content", columnDefinition = "TEXT", nullable = false)
	private String content;

	@Builder
	public Contact(Long contactId, String writerEmail, String content){
		this.contactId = contactId;
		this.writerEmail = writerEmail;
		this.content = content;
	}
}
