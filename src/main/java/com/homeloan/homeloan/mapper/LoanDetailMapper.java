package com.homeloan.homeloan.mapper;

import com.homeloan.homeloan.domain.CustomerDetailResponse;
import com.homeloan.homeloan.domain.LoanDetailResponse;
import com.homeloan.homeloan.domain.NomineeDetailsResponse;
import com.homeloan.homeloan.entity.LoanRequest;
import com.homeloan.homeloan.enums.LoanRequestStatusDetail;
import com.homeloan.homeloan.enums.LoanType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoanDetailMapper {

    public LoanDetailResponse mapEntityToDomain(Optional<LoanRequest> loanDetail) {

        NomineeDetailsResponse nomineeDetails = NomineeDetailsResponse.builder()
                .nomineeFirstName(loanDetail.get().getApplicant().getNominee().getFirstName())
                .nomineeLastName(loanDetail.get().getApplicant().getNominee().getLastName())
                .nomineeGender(loanDetail.get().getApplicant().getNominee().getGender())
                .nomineeAge(loanDetail.get().getApplicant().getNominee().getAge())
                .nomineeAddress(loanDetail.get().getApplicant().getNominee().getAddress())
                .build();
        CustomerDetailResponse applicantDetail = CustomerDetailResponse.builder()
                .firstName(loanDetail.get().getApplicant().getFirstName())
                .lastName(loanDetail.get().getApplicant().getLastName())
                .gender(loanDetail.get().getApplicant().getGender())
                .age(loanDetail.get().getApplicant().getAge())
                .mobileNo(loanDetail.get().getApplicant().getMobileNo())
                .email(loanDetail.get().getApplicant().getEmail())
                .address(loanDetail.get().getApplicant().getAddress())
                .build();

        LoanDetailResponse loanDetailResponse = LoanDetailResponse.builder()
                .loanRequestId(loanDetail.get().getLoanRequestId())
                .username(loanDetail.get().getUser().getUsername())
                .status(LoanRequestStatusDetail.valueOf(loanDetail.get().getStatus()))
                .loanType(LoanType.valueOf(loanDetail.get().getLoanType()))
                .nomineeDetailsResponse(nomineeDetails)
                .totalLoanAmount(loanDetail.get().getLoanAmount())
                .loanTenure(loanDetail.get().getLoanTenure())
                .currentLoanInterestRate(loanDetail.get().getLoanInterestRate())
                //.principalOutstandingAmount()
                //.outstandingEMICount()
                .customerDetailResponse(applicantDetail)
                .build();

        return loanDetailResponse;
    }
}
