package EFUB.homepage.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Develop extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	protected Long developId;

	@OneToOne(mappedBy = "develop", fetch = FetchType.LAZY)
	protected User user;

	@Column(length = 300)
	protected String motive;

	@Column(length = 100)
	protected String projectTopic;

	protected String applicationField;

	protected String language;

	protected Integer confidenceLang;

	protected String link;

	protected Boolean orientation;

	public Develop(String motive, String projectTopic, String applicationField,
				   String language, Integer confidenceLang, String link, Boolean orientation) {
		this.motive = motive;
		this.projectTopic = projectTopic;
		this.applicationField = applicationField;
		this.language = language;
		this.confidenceLang = confidenceLang;
		this.link = link;
		this.orientation = orientation;
	}
}
