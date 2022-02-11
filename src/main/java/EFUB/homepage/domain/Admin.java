package EFUB.homepage.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminNum;

    @Column
    private String password;

    @Column
    private String adminId;

    @Column
    private String role;

    @Builder
    public Admin(String adminId, String password) {
        this.adminId = adminId;
        this.password =password;
        role = "ADMIN";
    }
}
