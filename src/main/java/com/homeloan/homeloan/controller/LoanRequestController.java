package com.homeloan.homeloan.controller;

import com.homeloan.homeloan.domain.LoanApplicationReqResponse;
import com.homeloan.homeloan.domain.LoanRequestDetail;
import com.homeloan.homeloan.enums.Role;
import com.homeloan.homeloan.service.LoanRequestService;
import com.homeloan.homeloan.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.homeloan.homeloan.common.ConstantUtils.ADMIN_ROLE;

@CrossOrigin("*")
@RestController
@RequestMapping("/request")
//@PreAuthorize("hasRole('USER')")
@Slf4j
public class LoanRequestController {
    @Autowired
    private final LoanRequestService loanRequestService;

    @Autowired
    private JwtUtil jwtUtil;

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
    public ResponseEntity<LoanApplicationReqResponse> getRequestDetail(@PathVariable final Long loanRequestId, @RequestHeader("Authorization") String token) throws Exception {
        log.debug("fetching request details for requestId-{}", loanRequestId);
        String username = jwtUtil.extractUsername(token.substring(7)); // Extract username from token
        Role role = jwtUtil.extractRole(token.substring(7)); // Extract username from token
        LoanApplicationReqResponse loan = loanRequestService.getLoanRequestDetail(loanRequestId);
        if (ADMIN_ROLE.equals(role.name()) || loan.getUser().getUsername().equals(username)) {
            return ResponseEntity.status(HttpStatus.OK).body(loanRequestService.getLoanRequestDetail(loanRequestId));
        }
        //return ResponseEntity.ok(loan);
        return null;
    }

    @GetMapping()
    public ResponseEntity getRequestDetails(@RequestHeader("Authorization") String token) throws Exception {
        log.debug("fetching request details for All LoanRequest");
        String username = jwtUtil.extractUsername(token.substring(7)); // Extract username from token
        Role role = jwtUtil.extractRole(token.substring(7)); // Extract username from token
        if (ADMIN_ROLE.equals(role.name())) {
            return ResponseEntity.status(HttpStatus.OK).body(loanRequestService.getLoanRequestDetails());
        } else {
            return null;
        }

    }
}
