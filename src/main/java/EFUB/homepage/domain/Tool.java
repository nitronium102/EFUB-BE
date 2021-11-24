package EFUB.homepage.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name="Tool")
@Entity
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tool_id", nullable = false)
    private Long toolId;

    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name="tool", nullable = false)
    private String tool;

    @Builder
    public Tool(Long userId, String tool){
        this.userId = userId;
        this.tool = tool;
    }
}
