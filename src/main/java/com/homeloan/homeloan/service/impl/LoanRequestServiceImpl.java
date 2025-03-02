package com.homeloan.homeloan.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeloan.homeloan.domain.LoanApplicationReqResponse;
import com.homeloan.homeloan.domain.LoanRequestDetail;
import com.homeloan.homeloan.entity.LoanRequest;
import com.homeloan.homeloan.enums.LoanRequestStatusDetail;
import com.homeloan.homeloan.exception.IdNotFoundException;
import com.homeloan.homeloan.mapper.LoanRequestMapper;
import com.homeloan.homeloan.repository.LoanRequestRepository;
import com.homeloan.homeloan.service.LoanRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.homeloan.homeloan.common.ConstantUtils.NO_RECORD_EXIST;

@Service
@Slf4j
public class LoanRequestServiceImpl implements LoanRequestService {

    @Autowired
    private LoanRequestMapper loanRequestMapper;
    @Autowired
    private LoanRequestRepository loanRequestRepository;

    @Override
    public LoanApplicationReqResponse saveLoanRequest(LoanRequestDetail loanRequestDetail) throws JsonProcessingException {

        String loanRequestJson = null;
        ObjectMapper mapper = new ObjectMapper();
        loanRequestJson = mapper.writeValueAsString(loanRequestDetail);
        log.info("create loan application mapping :{}", loanRequestJson);
        LoanRequest loanRequest = loanRequestMapper.mapDomainToEntity(loanRequestDetail);
        LoanRequest result = loanRequestRepository.saveAndFlush(loanRequest);

        loanRequestJson = mapper.writeValueAsString(result);
        log.info("saving loan application :{}", loanRequestJson);

        return LoanApplicationReqResponse.builder()
                .loanRequestId(result.getLoanRequestId())
                .status(LoanRequestStatusDetail.valueOf(result.getStatus()))
                .build();
    }

    @Override
    public LoanApplicationReqResponse updateLoanRequest(LoanRequestDetail loanRequestDetail) {
        return null;
    }

    @Override
    public LoanApplicationReqResponse getLoanRequestDetail(Long loanRequestId) {

        log.info("find Home getHomeLoanById :{}", loanRequestId);

        Optional<LoanRequest> loanDetail = loanRequestRepository.findById(loanRequestId);

        if (ObjectUtils.isEmpty(loanDetail)) {
            String exceptionMessage = NO_RECORD_EXIST + " for given id:" + loanRequestId;
            throw new IdNotFoundException(exceptionMessage);
        }
        LoanApplicationReqResponse response = LoanApplicationReqResponse.builder()
                .loanRequestId(loanDetail.get().getLoanRequestId())
                .status(LoanRequestStatusDetail.valueOf(loanDetail.get().getStatus()))
                .build();
        return response;
    }

    @Override
    public List<LoanApplicationReqResponse> getLoanRequestDetails() {
        log.info("find All HomeLoan Request");
        List<LoanRequest> loanDetails = loanRequestRepository.findAll();
        if (ObjectUtils.isEmpty(loanDetails)) {
            String exceptionMessage = NO_RECORD_EXIST + " for any Loan Request:";
            throw new IdNotFoundException(exceptionMessage);
        }
        List<LoanApplicationReqResponse> responses = loanDetails.stream()
                .map(loanDetail -> LoanApplicationReqResponse.builder()
                        .loanRequestId(loanDetail.getLoanRequestId())
                        .status(LoanRequestStatusDetail.valueOf(loanDetail.getStatus()))
                        .build())
                .collect(Collectors.toList());

        return responses;

    }
}
