package com.homeloan.homeloan.model;

import com.homeloan.homeloan.enums.LoanStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "home_loans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HomeLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;
    private double interestRate;
    private double loanAmount;
    private int tenure;

    @Enumerated(EnumType.STRING)
    private LoanStatus status = LoanStatus.PENDING; // Default status
}
