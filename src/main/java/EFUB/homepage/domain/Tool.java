package EFUB.homepage.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Tool {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long toolId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
 	private User user;

	@Column(nullable = false)
	private String toolName;

	@Builder
	public Tool(String toolName) {
		this.toolName = toolName;
	}

	public void setUser(User user) {
		this.user = user;
		user.getTools().add(this);
	}

	public static Tool createTool(User user, String toolName) {
		Tool tool = Tool.builder().toolName(toolName).build();
		tool.setUser(user);
		return tool;
	}

}