package EFUB.homepage.domain;

import EFUB.homepage.dto.develop.DevApplyDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("L")
public class Lead extends Develop {
	@Column(length = 500)
	private String expProject;

	@Column(length = 300)
	private String expSolve;

	@Column(length = 100)
	private String seminarTopic;

	@Builder
	public Lead(String motive, String projectTopic, String applicationField, String language,
				Integer confidenceLang, String link, Boolean orientation, String expProject,
				String expSolve, String seminarTopic) {
		super.motive = motive;
		super.projectTopic = projectTopic;
		super.applicationField = applicationField;
		super.language = language;
		super.confidenceLang = confidenceLang;
		super.link = link;
		super.orientation = orientation;
		this.expProject = expProject;
		this.expSolve = expSolve;
		this.seminarTopic = seminarTopic;
	}

	public void setUser(User user) {
		super.user = user;
		user.setDevelop(this);
	}

	public static Lead createLead(User user, DevApplyDto apply) {
		Lead lead = Lead.builder()
			.motive(apply.getMotive())
			.projectTopic(apply.getProjectTopic())
			.applicationField(apply.getApplicationField())
			.language(apply.getLanguage())
			.confidenceLang(apply.getConfidenceLang())
			.link(apply.getLink())
			.orientation(apply.getOrientation())
			.expProject(apply.getExpProject())
			.expSolve(apply.getExpSolve())
			.seminarTopic(apply.getSeminarTopic())
			.build();
		lead.setUser(user);

		return lead;
	}
}
