package com.homeloan.homeloan.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long applicantId;

    @OneToOne
    @JoinColumn(name = "loan_request_id")
    private LoanRequest loanRequest;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "mobile_no")
    private Long mobileNo;

    @Column(name = "address")
    private String address;

    @Column(name = "create_dt")
    @CreationTimestamp
    private Timestamp createDt;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "modify_dt")
    @CreationTimestamp
    private Timestamp modifyDt;

    @Column(name = "modify_by")
    private String modifyBy;

    @OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL)
    private Nominee nominee;

}
