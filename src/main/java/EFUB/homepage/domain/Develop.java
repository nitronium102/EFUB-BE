package EFUB.homepage.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
public abstract class Develop extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long developId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(length = 350)
	private String motive;

	private String projectTopic;

	private String applicationField;

	private String language;

	private int confidenceLang;

	@Column(length = 1000)
	private String link;

	private Boolean orientation;

//	@Builder
//	public Develop(User user, String motive, String projectTopic, String applicationField,
//				   String language, int confidenceLang, String exp, String link, Boolean orientation) {
//		this.user = user;
//		this.motive = motive;
//		this.projectTopic = projectTopic;
//		this.applicationField = applicationField;
//		this.language = language;
//		this.confidenceLang = confidenceLang;
//		this.link = link;
//		this.orientation = orientation;
//	}
}
