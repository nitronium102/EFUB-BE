package EFUB.homepage.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Design extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long designId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(length = 350)
	private String motive;

	private int confidenceDes;

	private int confidenceTool;

	private String projectTopic;

	@Column(length = 5000)
	private String expDev;

	@Column(length = 5000)
	private String expDes;

	private String link;

	private Boolean interview;

	private Boolean orientation;

//	@Builder
//	public Design(User user, String motive, int confidenceDes, int confidenceTool, String projectTopic,
//				  String expDes, String expDev, String link, Boolean interview, Boolean orientation) {
//		this.user = user;
//		this.motive = motive;
//		this.confidenceDes = confidenceDes;
//		this.confidenceTool = confidenceTool;
//		this.projectTopic = projectTopic;
//		this.expDes = expDes;
//		this.expDev = expDev;
//		this.link = link;
//		this.interview = interview;
//		this.orientation = orientation;
//	}
}

