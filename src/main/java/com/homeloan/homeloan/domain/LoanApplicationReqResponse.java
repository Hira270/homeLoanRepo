package com.homeloan.homeloan.domain;

import com.homeloan.homeloan.enums.LoanRequestStatusDetail;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoanApplicationReqResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -6304335869593920162L;
    private Long loanRequestId;
    private LoanRequestStatusDetail status;


}
