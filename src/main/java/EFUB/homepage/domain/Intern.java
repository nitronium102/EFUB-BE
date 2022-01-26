package EFUB.homepage.domain;

import EFUB.homepage.dto.develop.DevApplyDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("I")
@Slf4j
public class Intern extends Develop {
	@Column(length = 500)
	private String expProject;

	@Column(length = 500)
	private String expStudy;

	@Builder
	public Intern(String motive, String projectTopic, String applicationField, String language,
				  Integer confidenceLang, String link, Boolean orientation, String expProject,
				  String expStudy) {
		super.motive = motive;
		super.projectTopic = projectTopic;
		super.applicationField = applicationField;
		super.language = language;
		super.confidenceLang = confidenceLang;
		super.link = link;
		super.orientation = orientation;
		this.expProject = expProject;
		this.expStudy = expStudy;
	}

	public void setUser(User user) {
		super.user = user;
		user.setDevelop(this);
	}

	public static Intern createIntern(User user, DevApplyDto apply) {
		Intern intern = Intern.builder()
			.motive(apply.getMotive())
			.projectTopic(apply.getProjectTopic())
			.applicationField(apply.getApplicationField())
			.language(apply.getLanguage())
			.confidenceLang(apply.getConfidenceLang())
			.link(apply.getLink())
			.orientation(apply.getOrientation())
			.expProject(apply.getExpProject())
			.expStudy(apply.getExpStudy())
			.build();
		intern.setUser(user);

		return intern;
	}
}
