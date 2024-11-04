package com.agus.ramdan.loan.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "loan_installment")
public class LoanInstallment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "simulation_id", nullable = true)
    private Long simulationId;

//    @Column(name = "deleted", nullable = false)
//    protected Boolean deleted = false;

    @Column(name = "number", nullable = false)
    protected Integer number;

    @Column(name = "maturity_date", nullable = false)
    protected LocalDate maturityDate;

//    @Column(name = "last_accrual_date", nullable = false)
//    protected LocalDate lastAccrualDate;

    @Column(name = "principal", precision = 12, scale = 2, nullable = false)
    protected BigDecimal principal;

    @Column(name = "interest", precision = 12, scale = 2, nullable = false)
    protected BigDecimal interest;

//    @Column(name = "paid_principal", precision = 12, scale = 2, nullable = false)
//    protected BigDecimal paidPrincipal;

//    @Column(name = "paid_interest", precision = 12, scale = 2, nullable = false)
//    protected BigDecimal paidInterest;
//
//    @Column(name = "olb", precision = 12, scale = 2, nullable = false)
//    protected BigDecimal olb;
//
//    @Column(name = "effective_at", nullable = false)
//    protected LocalDateTime effectiveAt;
//
//    @Column(name = "event_group_key", nullable = false)
//    protected Long eventGroupKey;
//
//    @Column(name = "rescheduled")
//    protected Boolean rescheduled;
}