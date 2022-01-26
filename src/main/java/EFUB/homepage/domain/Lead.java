package EFUB.homepage.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("L")
public class Lead extends Develop {
	private String expProject;
	private String expSolve;
	private String seminarTopic;
}
