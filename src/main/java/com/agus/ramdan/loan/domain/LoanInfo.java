package com.agus.ramdan.loan.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "loan_info")
public class LoanInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    // tenor OR number of month installment
    @Column(name = "tenor_months")
    private Integer tenorMonths;

    // percen interest rate per annum
    @Column(name = "interest_rate", precision = 8, scale = 4, nullable = false)
    private BigDecimal interestRate;

    // loan amount
    @Column(name = "amount")
    private BigDecimal amount;

    //
    //1. Start-of-Period
    //2. End-of-Period
    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "disbursement_date")
    private LocalDate disbursementDate;

    @Column(name = "maturity_date")
    private LocalDate maturityDate;

}