package EFUB.homepage.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long interviewId;

	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@Column(nullable = false)
	private String date;

	@Builder
	public Interview(String date) {
		this.date = date;
	}

	private void setUser(User user) {
		this.user = user;
		user.getInterviews().add(this);
	}

	public static Interview createInterview(User user, String date) {
		Interview interview = Interview.builder().date(date).build();
		interview.setUser(user);
		return interview;
	}

}