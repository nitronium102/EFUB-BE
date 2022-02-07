package EFUB.homepage.domain;

import EFUB.homepage.dto.user.UserResDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Enumerated(EnumType.STRING)
	private Position position;

	private String name;

	private String studentId;

	private String department;

	private String phoneNo;

	private String password;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "develop_id")
	private Develop develop;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "design_id")
	private Design design;

	@Column(nullable = false, columnDefinition = "boolean default 0")
	private Boolean passMid;

	@Column(nullable = false, columnDefinition = "boolean default 0")
	private Boolean passFinal;

	@OneToMany(mappedBy = "user")
	List<Tool> tools = new ArrayList<Tool>();

	@OneToMany(mappedBy = "user")
	List<Interview> interviews = new ArrayList<Interview>();

	@Builder
	public User(String name, String studentId, String department, String phoneNo, String password,
				Position position) {
		this.name = name;
		this.studentId = studentId;
		this.department = department;
		this.phoneNo = phoneNo;
		this.password = password;
		this.position = position;
		this.passMid = false;
		this.passFinal = false;
	}

	public void setDevelop(Develop develop) {
		this.develop = develop;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	public void updatePassMid(Boolean passMid) {
		this.passMid = passMid;
	}

	public void updatePassFinal(Boolean passFinal) {
		this.passFinal = passFinal;
	}

	public UserResDto toUserResDto() {
		String applicationUri = getApplicationUri();

		return UserResDto.builder()
				.department(department)
				.name(name)
				.passFinal(passFinal)
				.passMid(passMid)
				.phoneNo(phoneNo)
				.userId(userId)
				.position(position)
				.studentId(studentId)
				.applicationUri(applicationUri)
				.build();
	}

	private String getApplicationUri() {
		String applicationUri = "";
		switch (this.position) {
			case DESIGNER:
				applicationUri = "/api/admin/design/" + userId;
				break;
			case DEVELOPER_LEAD:
				applicationUri = "/api/admin/lead/" + userId;
				break;
			case DEVELOPER_INTERN:
				applicationUri = "/api/admin/intern/" + userId;
		}
		return applicationUri;
	}

}