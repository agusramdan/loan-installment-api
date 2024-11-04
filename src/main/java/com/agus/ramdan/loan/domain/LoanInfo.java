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

    @Column(name = "disbursement_date")
    private LocalDate disbursementDate;

    private Integer tenorYear;
    private Integer tenorMonths;

    @Column(name = "maturity_date")
    private LocalDate maturityDate;

    @Column(name = "interest_rate", precision = 8, scale = 4, nullable = false)
    private BigDecimal interestRate;

    @Column(name = "principal")
    private BigDecimal principal;

}