package com.secure.interviewschedular.domain;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author prabhakar, @Date 10-11-2024
 */
@Data
@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    private String mobile;
    private Integer ctc;
    private Integer eCtc;
    private String location;
    private String notice;
    private String resumeUrl;

}
