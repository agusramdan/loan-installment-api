package com.agus.ramdan.loan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class LoanInstallmentDto {
    protected Long id;

    @Schema(required = true)
    protected Integer number;

    @JsonProperty("accrued_date")
    @Schema(required = true)
    protected LocalDate accruedDate;

    @JsonProperty("maturity_date")
    @Schema(required = true)
    protected LocalDate maturityDate;

    @Schema(description = "Principal ", example = "100.00", required = true)
    protected BigDecimal principal;

    @Schema(description = "Interest ", example = "100.00", required = true)
    protected BigDecimal interest;

    @Schema(description = "Paid Principal ", example = "100.00", required = true)
    @JsonProperty(value = "paid_principal", index = 7)
    protected BigDecimal paidPrincipal;

    @Schema(description = "Paid interest ", example = "100.00", required = true)
    @JsonProperty(value = "paid_interest", index = 7)
    protected BigDecimal paidInterest;

    @Schema(description = "Paid instalment is paid_principal + paid_interest ", example = "100.00", required = true)
    @JsonProperty(value = "paid_instalment", index = 7)
    protected BigDecimal paidInstalment;

    @Schema(description = "Last Balance principal ", example = "100.00", required = true)
    @JsonProperty(value = "principal_balance", index = 8)
    protected BigDecimal principalBalance;

}
