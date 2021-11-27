package EFUB.homepage.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String name;

    @Column
    private Long studentId;

    @Column
    private String department;

    @Column
    private String phoneNo;

    @Column
    private String password;

    @Column
    private Boolean passMid;

    @Column
    private Boolean passFinal;

    @Column
    private Boolean saveFinal;

    @Column
    private Integer position;

    @Builder
    public User(String name, Long studentId, String department, String phoneNo, String password,
                Boolean passMid, Boolean passFinal, Boolean saveFinal, Integer position){
        this.name = name;
        this.studentId = studentId;
        this.department = department;
        this.phoneNo = phoneNo;
        this.password = password;
        this.passMid = passMid;
        this.passFinal = passFinal;
        this.saveFinal = saveFinal;
        this.position = position;
    }


	public void saveFinal() {
        this.saveFinal = true;
	}
}
