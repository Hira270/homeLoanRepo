package com.homeloan.homeloan.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.homeloan.homeloan.domain.LoanApplicationReqResponse;
import com.homeloan.homeloan.domain.LoanRequestDetail;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface LoanRequestService {

    LoanApplicationReqResponse saveLoanRequest(LoanRequestDetail loanRequestDetail) throws JsonProcessingException;
    LoanApplicationReqResponse updateLoanRequest(LoanRequestDetail loanRequestDetail);
    LoanApplicationReqResponse getLoanRequestDetail(Long loanRequestId);
    List<LoanApplicationReqResponse> getLoanRequestDetails();
}
