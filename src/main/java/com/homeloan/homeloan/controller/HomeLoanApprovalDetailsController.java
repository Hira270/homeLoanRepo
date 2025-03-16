package com.homeloan.homeloan.controller;

import com.homeloan.homeloan.domain.LoanApplicationReqResponse;
import com.homeloan.homeloan.entity.LoanRequest;
import com.homeloan.homeloan.repository.LoanRequestRepository;
import com.homeloan.homeloan.service.LoanRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home-loan-approval-details")
@Slf4j
public class HomeLoanApprovalDetailsController {

    @Autowired
    private LoanRequestService loanRequestService;

    @Autowired
    private LoanRequestRepository loanRequestRepository;

    @Autowired
    public HomeLoanApprovalDetailsController(LoanRequestService loanRequestService) {
        this.loanRequestService = loanRequestService;
    }

    // Get all home loan approval details
    @GetMapping
    public ResponseEntity<List<LoanApplicationReqResponse>> getAllHomeLoanApprovals() {
        log.debug("Fetching all home loan approval details.");
        return ResponseEntity.status(HttpStatus.OK).body(loanRequestService.getLoanRequestDetails());
    }


    // Get home loan approval details by ID
    @GetMapping("/{id}")
    public ResponseEntity<LoanApplicationReqResponse> getHomeLoanApprovalDetailsById(@PathVariable Long id) {
        log.debug("Fetching home loan approval details for loan ID: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(loanRequestService.getLoanRequestDetail(id));
    }

    @PutMapping("/{loanRequestId}/{status}")
    public ResponseEntity<String> updateLoanApprovalStatusById(@PathVariable Long loanRequestId,@PathVariable String status) {
        log.debug("Fetching all home loan approval details.");
        LoanRequest loanRequest=loanRequestService.getLoanRequestById(loanRequestId);
        loanRequest.setStatus(status);
        loanRequestRepository.saveAndFlush(loanRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Loan Request Updated Successfully");
    }
}
