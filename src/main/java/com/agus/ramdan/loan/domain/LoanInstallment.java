package com.agus.ramdan.loan.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "loan_installment")
@Schema
public class LoanInstallment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @JsonProperty(index = 1)
    private Long id;

    @Column(name = "paid_instalment", precision = 12, scale = 2, nullable = false)
    @Schema(description = "Paid instalment is principal + interest ", example = "100.00", required = true)
    @JsonProperty(value = "paid_instalment", index = 7)
    protected BigDecimal paidInstalment;

    @Column(name = "number", nullable = false)
    @Schema(description = "Number Installment", example = "1", required = true)
    @JsonProperty(index = 3)
    protected Integer number;

    @Column(name = "maturity_date", nullable = false)
    @Schema(required = true)
    @JsonProperty(value = "maturity_date", index = 4)
    protected LocalDate maturityDate;

    @Column(name = "principal", precision = 12, scale = 2, nullable = false)
    @Schema(example = "10000.00", required = true)
    @JsonProperty(index = 5)
    protected BigDecimal principal;

    @Column(name = "interest", precision = 12, scale = 2, nullable = false)
    @Schema(example = "100.00", required = true)
    @JsonProperty(index = 6)
    protected BigDecimal interest;
    @Column(name = "principal_balance", precision = 12, scale = 2, nullable = false)
    @Schema(description = "Last Balance principal ", example = "100.00", required = true)
    @JsonProperty(value = "principal_balance", index = 8)
    protected BigDecimal principalBalance;
    @Column(name = "info_id")
    @JsonProperty(value = "info_id", index = 2)
    @Schema(name = "info_id", example = "1", required = true)
    private Long infoId;

    //    @Column(name = "last_accrual_date", nullable = false)
//    protected LocalDate lastAccrualDate;

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