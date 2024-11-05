package com.agus.ramdan.loan.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "loan_installment")
@ApiModel
public class LoanInstallment {

    //    @Column(name = "deleted", nullable = false)
    //    protected Boolean deleted = false;
    @Column(name = "principal", precision = 12, scale = 2, nullable = false)
    @ApiModelProperty(example = "10000.00", required = true)
    @JsonProperty(index = 5)
    protected BigDecimal principal;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @JsonProperty(index = 1)
    @ApiModelProperty
    private Long id;

    @Column(name = "number", nullable = false)
    @ApiModelProperty(name = "Number Installment", example = "1", required = true)
    @JsonProperty(index = 3)
    protected Integer number;

    @Column(name = "maturity_date", nullable = false)
    @ApiModelProperty(required = true)
    @JsonProperty(value = "maturity_date", index = 4)
    protected LocalDate maturityDate;
    @Column(name = "info_id")
    @JsonProperty(value = "info_id", index = 2)
    @ApiModelProperty(name = "info_id", example = "1", required = true)
    private Long infoId;

    @Column(name = "interest", precision = 12, scale = 2, nullable = false)
    @ApiModelProperty(example = "100.00", required = true)
    @JsonProperty(index = 6)
    protected BigDecimal interest;

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