package com.secure.interviewschedular.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.secure.interviewschedular.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

/**
 * @author prabhakar, @Date 10-11-2024
 */
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String address;
    @Column(name = "email",unique = true, nullable = false)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    private String password;
    @Column
    private String mobile;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Column
    private String profileUrl;
    @Column(name = "forgotToken", unique = true, nullable = true)
    private String forgotToken;
    @Column
    private Integer otp;

}
