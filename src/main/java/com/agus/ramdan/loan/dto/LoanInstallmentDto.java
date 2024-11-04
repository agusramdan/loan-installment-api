package com.agus.ramdan.loan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class LoanInstallmentDto {
    protected Long id;

    @JsonProperty("simulation_id")
    protected Long simulationId;

    protected Integer number;

    @JsonProperty("maturity_date")
    protected LocalDate maturityDate;

    protected BigDecimal principal;

    protected BigDecimal interest;

}
