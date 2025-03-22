package com.homeloan.homeloan.controller;

import com.homeloan.homeloan.domain.LoanApplicationReqResponse;
import com.homeloan.homeloan.domain.LoanRequestDetail;
import com.homeloan.homeloan.enums.Role;
import com.homeloan.homeloan.exception.LoanRequestException;
import com.homeloan.homeloan.service.LoanRequestService;
import com.homeloan.homeloan.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.homeloan.homeloan.common.ConstantUtils.ADMIN_ROLE;

@CrossOrigin("*")
@RestController
@RequestMapping("/request")
@Slf4j
public class LoanRequestController {
    private final LoanRequestService loanRequestService;

    public final JwtUtil jwtUtil;

    public LoanRequestController(LoanRequestService loanRequestService, JwtUtil jwtUtil) {
        this.loanRequestService = loanRequestService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/createLoanRequest")
    public ResponseEntity<LoanApplicationReqResponse> createRequest(@Valid @RequestBody LoanRequestDetail loanRequestDetail, @RequestHeader("Authorization") String token) throws Exception {
        if (loanRequestDetail == null) {
            throw new IllegalArgumentException("please give valid credential");
        }
        log.debug("[createRequest] Begin");
        String username;
        try {
            username = jwtUtil.extractUsername(token.substring(7));
        } catch (Exception e) {
            throw new LoanRequestException("Invalid token");
        }

        LoanApplicationReqResponse response;
        try {
            response = loanRequestService.saveLoanRequest(loanRequestDetail, username);
        } catch (Exception e) {
            throw new LoanRequestException("Failed to create loan request");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{loanRequestId}")
    public ResponseEntity<LoanApplicationReqResponse> getRequestDetail(@PathVariable final Long loanRequestId, @RequestHeader("Authorization") String token) throws Exception {
        log.debug("fetching request details for requestId-{}", loanRequestId);
        String username;
        Role role;
        LoanApplicationReqResponse loan;

        try {
            username = jwtUtil.extractUsername(token.substring(7)); // Extract username from token
            role = jwtUtil.extractRole(token.substring(7)); // Extract role from token
            loan = loanRequestService.getLoanRequestDetail(loanRequestId);
        } catch (Exception ex) {
            throw new LoanRequestException("Invalid token or loan request details not found");
        }

        if (ADMIN_ROLE.equals(role.name()) || loan.getUsername().equals(username)) {
            return ResponseEntity.status(HttpStatus.OK).body(loanRequestService.getLoanRequestDetail(loanRequestId));
        } else {
            throw new LoanRequestException("Unauthorized access");
        }
    }

    @GetMapping()
    public ResponseEntity<List<LoanApplicationReqResponse>> getRequestDetails(@RequestHeader("Authorization") String token) throws Exception {
        log.debug("fetching request details for All LoanRequest");
        Role role;

        try {
            String username = jwtUtil.extractUsername(token.substring(7)); // Extract username from token
            role = jwtUtil.extractRole(token.substring(7)); // Extract role from token
        } catch (Exception e) {
            throw new LoanRequestException("Invalid token");
        }

        if (ADMIN_ROLE.equals(role.name())) {
            try {
                return ResponseEntity.status(HttpStatus.OK).body(loanRequestService.getLoanRequestDetails());
            } catch (Exception e) {
                throw new LoanRequestException("Failed to fetch loan request details");
            }
        } else {
            throw new LoanRequestException("Unauthorized access");
        }
    }
}
