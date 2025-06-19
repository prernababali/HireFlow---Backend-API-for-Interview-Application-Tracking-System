package com.secure.interviewschedular.repository;

import com.secure.interviewschedular.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author prabhakar, @Date 13-11-2024
 */
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
