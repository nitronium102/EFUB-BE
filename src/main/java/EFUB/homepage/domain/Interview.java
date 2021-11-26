package EFUB.homepage.domain;

import EFUB.homepage.dto.InterviewResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Table(name="Interview")
@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_id", nullable = false)
    private Long interviewId;

    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name="date", nullable = false)
    private String date;

    @Builder
    public Interview(Long userId, String date){
        this.userId = userId;
        this.date = date;
    }

    public static InterviewResDto toInterviewResDto(Interview interview) {
        return InterviewResDto.builder()
            .user_id(interview.getUserId())
            .interview_id(interview.getInterviewId())
            .date(interview.getDate())
            .build();
    }
}
