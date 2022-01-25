package EFUB.homepage.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
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
	private String tool;
}