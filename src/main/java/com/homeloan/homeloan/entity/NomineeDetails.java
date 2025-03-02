package com.homeloan.homeloan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "nominee_Details")
public class NomineeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nomineeId;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "address")
    private String address;

    @Column(name = "create_dt")
    private Date createDt;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "modify_dt")
    private Date modifyDt;

    @Column(name = "modify_by")
    private String modifyBy;

    // Getters and Setters
}