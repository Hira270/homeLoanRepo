package com.homeloan.homeloan.controller;

import com.homeloan.homeloan.domain.LoanApplicationReqResponse;
import com.homeloan.homeloan.domain.LoanRequestDetail;
import com.homeloan.homeloan.service.LoanRequestService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/request")
@Slf4j
public class LoanRequestController {
    @Autowired
    private final LoanRequestService loanRequestService;

    public LoanRequestController(LoanRequestService loanRequestService) {
        this.loanRequestService = loanRequestService;
    }

    @PostMapping(path = "/createLoanRequest")
    public ResponseEntity<LoanApplicationReqResponse> createRequest(@Valid @RequestBody LoanRequestDetail loanRequestDetail) throws Exception {
        log.debug("[createRequest] Begin");
        return ResponseEntity.status(HttpStatus.CREATED).body(loanRequestService.saveLoanRequest(loanRequestDetail));
    }

    @PostMapping(path = "/updateRequest")
    public ResponseEntity<LoanApplicationReqResponse> updateRequest(@Valid @RequestBody LoanRequestDetail loanRequestDetail) throws Exception {
        log.debug("Updating request for requestId-{}", loanRequestDetail.getLoanRequestId());
        return ResponseEntity.status(HttpStatus.CREATED).body(loanRequestService.updateLoanRequest(loanRequestDetail));
    }

    @GetMapping("/{loanRequestId}")
    public ResponseEntity<LoanApplicationReqResponse> getRequestDetail(@PathVariable final Long loanRequestId) throws Exception {
        log.debug("fetching request details for requestId-{}", loanRequestId);
        return ResponseEntity.status(HttpStatus.OK).body(loanRequestService.getLoanRequestDetail(loanRequestId));

    }

    @GetMapping()
    public ResponseEntity getRequestDetails() throws Exception {
        log.debug("fetching request details for All LoanRequest");
        return ResponseEntity.status(HttpStatus.OK).body(loanRequestService.getLoanRequestDetails());
    }
}
