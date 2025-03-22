package com.homeloan.homeloan.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Builder
@Table(name = "home_loan_Offer_details")
@AllArgsConstructor
@NoArgsConstructor
public class HomeLoanOfferDetails {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "home_loan_Offer_details_id")
    private Long homeLoanOfferDetailsId;

    @Column(name = "processing_fee")
    private Double processingFee;

    @Column(name = "loan_tenure")
    private Integer loanTenure;

    @Column(name = "loan_interest_rate")
    private Double loanInterestRate;

    @Column(name = "loan_amount")
    private Double loanAmount;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "home_loan_Offer_id")
    @JsonBackReference
    private HomeLoanOffer homeLoanOffer;


}
