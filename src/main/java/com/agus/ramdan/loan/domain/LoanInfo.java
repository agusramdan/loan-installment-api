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
@Table(name = "loan_info")
@Schema
public class LoanInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @JsonProperty(index = 1)
    private Long id;
    @Column(name = "amortization")
    @JsonProperty(value = "amortization", index = 2)
    @Schema(description = "amortization formula have value PAT, FLAT, SLIDING, RC FLAT, RC,FLAT LINKAGE,PPBT,FLAT INSTALLMENT,FLAT POKOK SEKALIGUS,FLAT POKOK BUNGA SEKALIGUS")
    private String amortization;

    // tenor OR number of month installment
    @Column(name = "tenor_months")
    @JsonProperty(value = "tenor_months", index = 3)
    @Schema
    private Integer tenorMonths;

    // percen interest rate per annum
    @Column(name = "interest_rate", precision = 8, scale = 4, nullable = false)
    @JsonProperty(value = "interest_rate", index = 4)
    @Schema
    private BigDecimal interestRate;

    // loan amount
    @Column(name = "amount")
    @JsonProperty(value = "amount", index = 10)
    @Schema
    private BigDecimal amount;

    //1. Start-of-Period
    //2. In-Arrear / Bayar Bln Berikut
    @Schema(description = "value of In-Arrear / Bayar Bln Berikut,  In-Advance / Bayar Dimuka")
    @Column(name = "payment_method")
    @JsonProperty(value = "payment_method", index = 11)
    private String paymentMethod;

    @Column(name = "disbursement_date")
    @JsonProperty(value = "disbursement_date", index = 12)
    @Schema
    private LocalDate disbursementDate;

    @Column(name = "maturity_date")
    @JsonProperty(value = "maturity_date", index = 13)
    @Schema
    private LocalDate maturityDate;


}