package com.homeloan.homeloan.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@Builder
@Table(name = "home_loan_Offer_details")
@AllArgsConstructor
@NoArgsConstructor
public class HomeLoanOfferDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_loan_Offer_details_id")
    private Long homeLoanOfferDetailsId;

    @Column(name = "processing_fee")
    private Double processingFee;

    @Column(name = "loan_tenure")
    private String loanTenure;

    @Column(name = "loan_interestRate")
    private Double loanInterestRate;

    @Column(name = "loan_amount")
    private Double loanAmount;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    // Getters and Setters
    public Long getHomeLoanOfferDetailsId() {
        return homeLoanOfferDetailsId;
    }

    public void setHomeLoanOfferDetailsId(Long homeLoanOfferDetailsId) {
        this.homeLoanOfferDetailsId = homeLoanOfferDetailsId;
    }

    public Double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(Double processingFee) {
        this.processingFee = processingFee;
    }

    public String getLoanTenure() {
        return loanTenure;
    }

    public void setLoanTenure(String loanTenure) {
        this.loanTenure = loanTenure;
    }

    public Double getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(Double loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
