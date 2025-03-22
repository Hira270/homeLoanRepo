package com.homeloan.homeloan.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Setter
@Getter
@Entity
@Builder
@Table(name = "home_loan_Offer_details")
@AllArgsConstructor
@NoArgsConstructor
public class HomeLoanOffer {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "home_loan_Offer_id")
    private Long homeLoanOfferId;

    @Column(name = "loan_amount")
    private Double loanAmount;

    @Column(name = "loan_interest_rate")
    private Double loanInterestRate;

    @Column(name = "valid_up_to")
    private Date validUpTo;




}
