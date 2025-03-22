package com.homeloan.homeloan.domain;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import static com.homeloan.homeloan.common.ConstantUtils.*;
import static com.homeloan.homeloan.common.ConstantUtils.PLEASE_PROVIDE_MOBILE_NUMBER;

@Data
@Builder
public class CustomerDetailResponse {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private Long mobileNo;
    private String email;
    private String address;
}
