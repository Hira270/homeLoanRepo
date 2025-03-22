package com.homeloan.homeloan.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NomineeDetailsResponse {
    private String nomineeFirstName;
    private String nomineeLastName;
    private String nomineeGender;
    private int nomineeAge;
    private String nomineeAddress;
}
