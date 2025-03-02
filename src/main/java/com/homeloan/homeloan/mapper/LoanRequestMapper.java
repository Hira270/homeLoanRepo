package com.homeloan.homeloan.mapper;

import com.homeloan.homeloan.domain.LoanRequestDetail;
import com.homeloan.homeloan.entity.Applicant;
import com.homeloan.homeloan.entity.LoanRequest;
import org.springframework.stereotype.Component;

@Component
public class LoanRequestMapper {

    public LoanRequest mapDomainToEntity(LoanRequestDetail loanRequestDetail){
        Applicant applicant=Applicant.builder()
                .firstName(loanRequestDetail.getApplicantDetail().getFirstName())
                .lastName(loanRequestDetail.getApplicantDetail().getLastName())
                .address(loanRequestDetail.getApplicantDetail().getAddress())
                .age(loanRequestDetail.getApplicantDetail().getAge())
                .mobileNo(loanRequestDetail.getApplicantDetail().getMobileNo())
                .build();

        return LoanRequest.builder()
                .loanAmount(loanRequestDetail.getLoanAmount())
                .requestLoanType(loanRequestDetail.getRequest_loanType())
                .loanTenure(loanRequestDetail.getLoanTenure())
                .approvedBy(loanRequestDetail.getApproveBy())
                .endDate(loanRequestDetail.getEndDate())
                .startDate(loanRequestDetail.getStartDate())
                .status(loanRequestDetail.getLoanStatus().toString())
                .applicant(applicant)
                .build();
    }

}
