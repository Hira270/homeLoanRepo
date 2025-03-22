package com.homeloan.homeloan.domain;

import com.homeloan.homeloan.enums.LoanStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import static com.homeloan.homeloan.common.ConstantUtils.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoanRequestDetail implements Serializable {
    @Serial
    private static final long serialVersionUID = -3994772458269559553L;
    private Long loanRequestId;
    private String requestLoanType;
    private String description;
    private LoanStatus loanStatus;
    @NotNull(message = PLEASE_PROVIDE_LOAN_TENURE)
    private String loanTenure;
    @NotNull(message = PLEASE_PROVIDE_LOAN_AMOUNT)
    private Double loanAmount;
    @NotNull(message = PLEASE_PROVIDE_LOAN_INTEREST_RATE)
    private Double loanInterestRate;
    @NotNull(message = PLEASE_PROVIDE_START_DATE)
    private Date startDate;
    @NotNull(message = PLEASE_PROVIDE_END_DATE)
    private Date endDate;
    private String approveBy;
    @Valid
    @NotNull
    private ApplicantDetail applicantDetail;

}