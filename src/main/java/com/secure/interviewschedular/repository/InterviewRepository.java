package com.secure.interviewschedular.repository;

import com.secure.interviewschedular.domain.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author prabhakar, @Date 13-11-2024
 */
@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
    List<Interview> getInterviewByScheduler_Email(String schedulerMail);
}
