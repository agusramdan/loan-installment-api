package com.agus.ramdan.loan.controller;

import com.agus.ramdan.loan.domain.LoanInfo;
import com.agus.ramdan.loan.domain.LoanInstallment;
import com.agus.ramdan.loan.exception.ResourceNotFoundException;
import com.agus.ramdan.loan.repository.LoanInstallmentRepository;
import com.agus.ramdan.loan.utils.BeanUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan/installment")
public class LoanInstallmentController {
    @Autowired
    LoanInstallmentRepository loanInstallmentRepository;

    @GetMapping("")
    @Operation(summary = "Get Loan Installment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = LoanInstallment.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid tag value", content = @Content) })
    public ResponseEntity<List<LoanInstallment>> getAllLoanInstallments(
            @RequestParam(name = "info_id", required = false) Long infoId) {
        List<LoanInstallment> loanInstallments = loanInstallmentRepository.findAllByInfoId(infoId, Sort.by("number", "id"));

        if (loanInstallments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(loanInstallments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Loan Installment By Id")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation",content = { @Content(mediaType = "application/json", schema = @Schema(implementation = LoanInstallment.class)), })
    })
    public ResponseEntity<LoanInstallment> getLoanInstallmentById(@PathVariable("id") long id)
            throws ResourceNotFoundException {
        LoanInstallment loanInstallment = loanInstallmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan Installment not found for this id :: " + id));
        return ResponseEntity.ok().body(loanInstallment);
    }

    @PostMapping("")
    @Operation(summary = "Create Loan Installment")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation",content = { @Content(mediaType = "application/json", schema = @Schema(implementation = LoanInstallment.class)), })
    })
    public ResponseEntity<LoanInstallment> createLoanInstallment(@RequestBody LoanInstallment loanInstallment) {
        LoanInstallment _loanInstallment = loanInstallmentRepository.save(loanInstallment);
        return ResponseEntity.status(HttpStatus.CREATED).body(_loanInstallment);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Loan Installment")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation",content = { @Content(mediaType = "application/json", schema = @Schema(implementation = LoanInstallment.class)), })
    })
    public ResponseEntity<LoanInstallment> updateLoanInstallment(
            @PathVariable("id") long id,
            @RequestBody LoanInstallment _loanInstallment)
            throws ResourceNotFoundException {
        LoanInstallment loanInstallment = loanInstallmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan Installment not found for this id :: " + id));
        BeanUtils.copyNonNullProperties(_loanInstallment, loanInstallment);
        loanInstallment = loanInstallmentRepository.save(loanInstallment);
        return ResponseEntity.ok().body(loanInstallment);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Loan Installment By Id")
    public ResponseEntity<HttpStatus> deleteLoanInstallment(@PathVariable("id") long id) {
        loanInstallmentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
