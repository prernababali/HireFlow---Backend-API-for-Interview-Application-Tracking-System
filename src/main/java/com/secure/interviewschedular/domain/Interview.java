package com.secure.interviewschedular.domain;

import com.secure.interviewschedular.enums.InterviewStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author prabhakar, @Date 10-11-2024
 */
@Entity
@Table(name = "interview")
@Data
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;

    @OneToOne(optional = false)
    @JoinColumn(name = "scheduler_id", referencedColumnName = "id")
    private User scheduler;

    @OneToOne(optional = false)
    @JoinColumn(name = "interviewer_id", referencedColumnName = "id")
    private User interviewer;
    private LocalDateTime dateTime;

    @OneToOne(optional = false)
    @JoinColumn(name = "talent_id", referencedColumnName = "id")
    private Talent talent;

    @Enumerated(EnumType.STRING)
    private InterviewStatus interviewStatus;
    private String meetingLik;
}
