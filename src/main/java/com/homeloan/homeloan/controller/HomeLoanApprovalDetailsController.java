package com.homeloan.homeloan.controller;

import com.homeloan.homeloan.domain.LoanApplicationReqResponse;
import com.homeloan.homeloan.entity.LoanRequest;
import com.homeloan.homeloan.service.LoanRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home-loan-approval-details")
public class HomeLoanApprovalDetailsController {

    @Autowired
    private LoanRequestService loanRequestService;

    @Autowired
    public HomeLoanApprovalDetailsController(LoanRequestService loanRequestService) {
        this.loanRequestService = loanRequestService;
    }

    // Get all home loan approval details
    @GetMapping
    public ResponseEntity<List<LoanApplicationReqResponse>> getAllHomeLoanApprovals() {
        return ResponseEntity.status(HttpStatus.OK).body(loanRequestService.getLoanRequestDetails());
    }

    // Get home loan approval details by ID
    @GetMapping("/{id}")
    public ResponseEntity<LoanApplicationReqResponse> getHomeLoanApprovalDetailsById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(loanRequestService.getLoanRequestDetail(id));
    }
}
