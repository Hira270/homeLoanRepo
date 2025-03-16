package com.homeloan.homeloan.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Setter
@Getter
@Builder
@Table(name = "loan_request")
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long loanRequestId;

    @Column(name = "request_loan_type")
    private String requestLoanType;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "loan_amount")
    private Double loanAmount;

    @Column(name = "loan_tenure")
    private String loanTenure;

    @Column(name = "loan_interest_rate")
    private Double loanInterestRate;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "approved_by")
    private String approvedBy;

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

    @OneToOne(mappedBy = "loanRequest", cascade = CascadeType.ALL)
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}