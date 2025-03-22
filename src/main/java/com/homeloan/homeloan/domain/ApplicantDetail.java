package com.homeloan.homeloan.domain;

import com.homeloan.homeloan.entity.Nominee;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

import static com.homeloan.homeloan.common.ConstantUtils.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApplicantDetail implements Serializable {
    @Serial
    private static final long serialVersionUID = -8763663076390288296L;
    @NotNull(message = PLEASE_PROVIDE_FIRST_NAME)
    private String firstName;
    @NotNull(message = PLEASE_PROVIDE_LAST_NAME)
    private String lastName;
    @NotNull(message = PLEASE_PROVIDE_GENDER)
    private String gender;
    private int age;
    @NotNull(message = PLEASE_PROVIDE_MOBILE_NUMBER)
    private Long mobileNo;
    private String email;
    private String address;
    private NomineeDetails nomineeDetails;

}
