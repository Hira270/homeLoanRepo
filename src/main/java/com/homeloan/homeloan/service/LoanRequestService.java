package com.homeloan.homeloan.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.homeloan.homeloan.domain.LoanApplicationReqResponse;
import com.homeloan.homeloan.domain.LoanRequestDetail;

import java.util.List;

public interface LoanRequestService {

    LoanApplicationReqResponse saveLoanRequest(LoanRequestDetail loanRequestDetail) throws JsonProcessingException;

    LoanApplicationReqResponse updateLoanRequest(LoanRequestDetail loanRequestDetail);

    LoanApplicationReqResponse getLoanRequestDetail(Long loanRequestId);

    List<LoanApplicationReqResponse> getLoanRequestDetails();
}
