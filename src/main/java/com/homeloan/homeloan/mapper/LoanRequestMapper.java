package com.homeloan.homeloan.mapper;

import com.homeloan.homeloan.domain.LoanRequestDetail;
import com.homeloan.homeloan.entity.Applicant;
import com.homeloan.homeloan.entity.LoanRequest;
import com.homeloan.homeloan.entity.Nominee;
import com.homeloan.homeloan.entity.User;
import org.springframework.stereotype.Component;

@Component
public class LoanRequestMapper {

    public LoanRequest mapDomainToEntity(LoanRequestDetail loanRequestDetail, User loggedInUser) {

        User user = User.builder()
                .id(loggedInUser.getId())
                .build();

        LoanRequest loanRequest = LoanRequest.builder()
                .loanAmount(loanRequestDetail.getLoanAmount())
                .requestLoanType(loanRequestDetail.getRequestLoanType())
                .loanTenure(loanRequestDetail.getLoanTenure())
                .approvedBy(loanRequestDetail.getApproveBy())
                .endDate(loanRequestDetail.getEndDate())
                .startDate(loanRequestDetail.getStartDate())
                .status(loanRequestDetail.getLoanStatus().toString())
                .description(loanRequestDetail.getDescription())
                .loanInterestRate(loanRequestDetail.getLoanInterestRate())
                .createBy(loggedInUser.getUsername())
                .modifyBy(loggedInUser.getUsername())
                .user(user)
                .build();
        applicantMapping(loanRequest, loanRequestDetail, loggedInUser);
        return loanRequest;


    }

    private void applicantMapping(LoanRequest loanRequest, LoanRequestDetail loanRequestDetail, User loggedInUser) {

        Applicant applicant = Applicant.builder()
                .firstName(loanRequestDetail.getApplicantDetail().getFirstName())
                .lastName(loanRequestDetail.getApplicantDetail().getLastName())
                .address(loanRequestDetail.getApplicantDetail().getAddress())
                .age(loanRequestDetail.getApplicantDetail().getAge())
                .mobileNo(loanRequestDetail.getApplicantDetail().getMobileNo())
                .gender(loanRequestDetail.getApplicantDetail().getGender())
                .createBy(loggedInUser.getUsername())
                .modifyBy(loggedInUser.getUsername())
                .loanRequest(loanRequest)
                .build();
        loanRequest.setApplicant(applicant);

        nomineeMapping(applicant, loanRequestDetail, loggedInUser);
    }

    private void nomineeMapping(Applicant applicant, LoanRequestDetail loanRequestDetail, User loggedInUser) {

        Nominee nominee = Nominee.builder()
                .firstName(loanRequestDetail.getApplicantDetail().getNomineeDetails().getNomineeFirstName())
                .lastName(loanRequestDetail.getApplicantDetail().getNomineeDetails().getNomineeLastName())
                .gender(loanRequestDetail.getApplicantDetail().getNomineeDetails().getNomineeGender())
                .age(loanRequestDetail.getApplicantDetail().getNomineeDetails().getNomineeAge())
                .address(loanRequestDetail.getApplicantDetail().getNomineeDetails().getNomineeAddress())
                .createBy(loggedInUser.getUsername())
                .modifyBy(loggedInUser.getUsername())
                .applicant(applicant)
                .build();
        applicant.setNominee(nominee);

    }
}
