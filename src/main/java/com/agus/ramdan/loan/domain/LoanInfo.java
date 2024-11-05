package com.agus.ramdan.loan.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(index = 1)
    private Long id;

    // tenor OR number of month installment
    @Column(name = "tenor_months")
    @JsonProperty(value = "tenor_months", index = 2)
    private Integer tenorMonths;

    // percen interest rate per annum
    @Column(name = "interest_rate", precision = 8, scale = 4, nullable = false)
    @JsonProperty(value = "interest_rate", index = 3)
    private BigDecimal interestRate;

    // loan amount
    @Column(name = "amount")
    @JsonProperty(value = "amount", index = 4)
    private BigDecimal amount;

    //
    //1. Start-of-Period
    //2. End-of-Period
    @Column(name = "payment_method")
    @JsonProperty(value = "payment_method", index = 5)
    private String paymentMethod;

    @Column(name = "disbursement_date")
    @JsonProperty(value = "disbursement_date", index = 6)
    private LocalDate disbursementDate;

    @Column(name = "maturity_date")
    @JsonProperty(value = "maturity_date", index = 7)
    private LocalDate maturityDate;

}