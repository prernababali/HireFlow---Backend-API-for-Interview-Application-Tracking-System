package com.secure.interviewschedular.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author prabhakar, @Date 10-11-2024
 */
@Entity
@Table(name = "talent")
@Data
public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String requirements;
    private String projectName;
    private String managerName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String jobLocation;
}
