package com.homeloan.homeloan.controller;

import com.homeloan.homeloan.domain.LoanApplicationReqResponse;
import com.homeloan.homeloan.entity.LoanRequest;
import com.homeloan.homeloan.enums.LoanStatus;
import com.homeloan.homeloan.exception.InvalidStatusException;
import com.homeloan.homeloan.exception.LoanRequestException;
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


    private final LoanRequestService loanRequestService;


    private final LoanRequestRepository loanRequestRepository;

    @Autowired
    public HomeLoanApprovalDetailsController(LoanRequestService loanRequestService, LoanRequestRepository loanRequestRepository) {
        this.loanRequestService = loanRequestService;
        this.loanRequestRepository = loanRequestRepository;
    }

    @GetMapping
    public ResponseEntity<List<LoanApplicationReqResponse>> getAllHomeLoanApprovals() {
        log.debug("Fetching all home loan approval details.");
        try {
            return ResponseEntity.status(HttpStatus.OK).body(loanRequestService.getLoanRequestDetails());
        } catch (Exception e) {
            throw new LoanRequestException("Failed to fetch loan request details");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanApplicationReqResponse> getHomeLoanApprovalDetailsById(@PathVariable Long id) {
        log.debug("Fetching home loan approval details for loan ID: {}", id);
        LoanApplicationReqResponse loan;
        try {
            loan = loanRequestService.getLoanRequestDetail(id);
            if (loan == null) {
                throw new LoanRequestException("Failed to fetch loan request details for ID: " + id);
            }
        } catch (Exception e) {
            throw new LoanRequestException("Failed to fetch loan request details for ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(loan);
    }

    @PutMapping("/{loanRequestId}/{status}")
    public ResponseEntity<String> updateLoanApprovalStatusById(@PathVariable Long loanRequestId, @PathVariable String status) {
        LoanRequest loanRequest = loanRequestService.getLoanRequestById(loanRequestId);
        if (loanRequest == null) {
            return new ResponseEntity<>("Loan request not found for ID: " + loanRequestId, HttpStatus.NOT_FOUND);
        }

        try {
            // Assuming validStatus is an enum
            LoanStatus validStatus = LoanStatus.valueOf(status.toUpperCase());
            loanRequest.setStatus(validStatus.name()); // Use the enum name to ensure consistency
            loanRequestRepository.saveAndFlush(loanRequest);
            return new ResponseEntity<>("Loan Request Status Updated Successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            throw new InvalidStatusException("Invalid status: " + status);
        }
    }
}
