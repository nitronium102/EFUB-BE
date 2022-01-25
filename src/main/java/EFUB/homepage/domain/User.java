package EFUB.homepage.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Entity(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Enumerated(EnumType.STRING)
	private Position position;

	private String name;

	private Long studentId;

	private String department;

	private String phoneNo;

	private String password;

	@OneToOne(mappedBy = "user", fetch = LAZY)
	private Develop developId;

	@OneToOne(mappedBy = "user", fetch = LAZY)
	private Design designId;

	private Boolean passFirst;

	private Boolean passFinal;

	@OneToMany(mappedBy = "user")
	List<Tool> tools = new ArrayList<Tool>();

	@OneToMany(mappedBy = "user")
	List<Interview> interviews = new ArrayList<Interview>();

	@Builder
	public User(String name, Long studentId, String department, String phoneNo, String password,
				Boolean passFirst, Boolean passFinal) {
		this.name = name;
		this.studentId = studentId;
		this.department = department;
		this.phoneNo = phoneNo;
		this.password = password;
		this.passFinal = passFinal;
		this.passFirst = passFirst;
	}
}