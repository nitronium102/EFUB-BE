package EFUB.homepage.domain;

import EFUB.homepage.dto.design.DesApplyDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Design extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long designId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(length = 300)
	private String motive;

	private int confidenceTool;

	@Column(length = 300)
	private String activityPlan;

	@Column(length = 300)
	private String expSolve;

	private String link;

	private Boolean orientation;

	@Builder
	public Design(User user, String motive, int confidenceTool, String activityPlan,
				  String expSolve, String link, Boolean orientation) {
		this.user = user;
		this.motive = motive;
		this.confidenceTool = confidenceTool;
		this.activityPlan = activityPlan;
		this.expSolve = expSolve;
		this.link = link;
		this.orientation = orientation;
	}

	private void setUser(User user) {
		this.user = user;
		user.setDesign(this);
	}

	public static Design createDesign(User user, DesApplyDto apply) {
		Design design = Design.builder()
			.motive(apply.getMotive())
			.confidenceTool(apply.getConfidenceTool())
			.activityPlan(apply.getActivityPlan())
			.expSolve(apply.getExpSolve())
			.link(apply.getLink())
			.orientation(apply.getOrientation())
			.build();
		design.setUser(user);

		return design;
	}
}

