package com.secure.interviewschedular.domain;

import com.secure.interviewschedular.enums.InterviewStatus;
import jakarta.persistence.*;
import lombok.Data;

/**
 * @author prabhakar, @Date 10-11-2024
 */
@Entity
@Table(name = "feedback")
@Data
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;

    @OneToOne
    @JoinColumn(name = "interview_id", referencedColumnName = "id")
    private Interview interview;

    @Enumerated(EnumType.STRING)
    private InterviewStatus status;
    private String remark;
    private String rating;
}
