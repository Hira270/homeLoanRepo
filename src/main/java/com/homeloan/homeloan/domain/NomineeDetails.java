package com.homeloan.homeloan.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NomineeDetails {
    private String nomineeFirstName;
    private String nomineeLastName;
    private String nomineeGender;
    private int nomineeAge;
    private String nomineeAddress;
}
