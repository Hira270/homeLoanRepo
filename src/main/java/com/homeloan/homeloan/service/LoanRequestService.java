package com.homeloan.homeloan.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.homeloan.homeloan.domain.LoanApplicationReqResponse;
import com.homeloan.homeloan.domain.LoanRequestDetail;
import com.homeloan.homeloan.entity.LoanRequest;

import java.util.List;

public interface LoanRequestService {

    LoanApplicationReqResponse saveLoanRequest(LoanRequestDetail loanRequestDetail, String username) throws JsonProcessingException;

    LoanApplicationReqResponse updateLoanRequest(LoanRequestDetail loanRequestDetail);

    LoanApplicationReqResponse getLoanRequestDetail(Long loanRequestId);

    List<LoanApplicationReqResponse> getLoanRequestDetails();

    LoanRequest getLoanRequestById(Long id);
}
