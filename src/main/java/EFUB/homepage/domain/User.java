package EFUB.homepage.domain;

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
@Entity(name = "user")
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

	@OneToOne(mappedBy = "user", fetch = LAZY)
	private Develop develop;

	@OneToOne(mappedBy = "user", fetch = LAZY)
	private Design design;

	@Column(nullable = false, columnDefinition = "boolean default 0")
	private Boolean passFirst;

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
		this.passFirst = false;
		this.passFinal = false;
	}

	public void setDevelop(Develop develop) {
		this.develop = develop;
	}

	public void setDesign(Design design) { this.design = design;}
}