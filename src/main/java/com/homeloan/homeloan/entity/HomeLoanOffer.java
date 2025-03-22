package com.homeloan.homeloan.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Setter
@Getter
@Entity
@Builder
@Table(name = "home_loan_Offer")
@AllArgsConstructor
@NoArgsConstructor
public class HomeLoanOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "home_loan_Offer_id")
    private Long homeLoanOfferId;

    @Column(name = "loan_amount")
    private Double loanAmount;

    @Column(name = "loan_interest_rate")
    private Double loanInterestRate;
    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "valid_up_to")
    private Date validUpTo;
    @OneToOne(mappedBy = "homeLoanOffer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private HomeLoanOfferDetails homeLoanOfferDetails;

}
