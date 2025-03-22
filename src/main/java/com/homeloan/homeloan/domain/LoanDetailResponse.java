package com.homeloan.homeloan.domain;

import com.homeloan.homeloan.enums.LoanRequestStatusDetail;
import com.homeloan.homeloan.enums.LoanType;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LoanDetailResponse {
    private Long loanRequestId;
    private String username;
    private LoanRequestStatusDetail status;
    private LoanType loanType;
    private NomineeDetailsResponse nomineeDetailsResponse;
    private Double totalLoanAmount;
    private Integer loanTenure;
    private Double currentLoanInterestRate;
    private Double principalOutstandingAmount;
    private Integer outstandingEMICount;
    private CustomerDetailResponse customerDetailResponse;
}
