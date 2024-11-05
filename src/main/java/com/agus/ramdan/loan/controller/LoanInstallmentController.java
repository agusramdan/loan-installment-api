package com.agus.ramdan.loan.controller;

import com.agus.ramdan.loan.domain.LoanInstallment;
import com.agus.ramdan.loan.exception.ResourceNotFoundException;
import com.agus.ramdan.loan.repository.LoanInstallmentRepository;
import com.agus.ramdan.loan.utils.BeanUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ApiOperation(value = "Get Loan Installment",
            response = LoanInstallment.class)
    public ResponseEntity<List<LoanInstallment>> getAllLoanInstallments(
            @RequestParam(name = "info_id", required = false) Long infoId) {
        try {
            List<LoanInstallment> loanInstallments = loanInstallmentRepository.findAllByInfoId(infoId);

            if (loanInstallments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(loanInstallments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanInstallment> getLoanInstallmentById(@PathVariable("id") long id)
            throws ResourceNotFoundException {
        LoanInstallment loanInstallment = loanInstallmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan Installment not found for this id :: " + id));
        return ResponseEntity.ok().body(loanInstallment);
    }

    @PostMapping("")
    @ApiOperation(value = "Create Loan Installment",
            response = LoanInstallment.class)
    public ResponseEntity<LoanInstallment> createLoanInstallment(@RequestBody LoanInstallment loanInstallment) {
        try {
            LoanInstallment _loanInstallment = loanInstallmentRepository.save(loanInstallment);
            return ResponseEntity.status(HttpStatus.CREATED).body(_loanInstallment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Loan Installment",
            response = LoanInstallment.class)
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
    public ResponseEntity<HttpStatus> deleteLoanInstallment(@PathVariable("id") long id) {
        try {
            loanInstallmentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @DeleteMapping("/installment")
//    public ResponseEntity<HttpStatus> deleteAllLoanInstallments() {
//        try {
//            loanInstallmentRepository.deleteAll();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }

//  @GetMapping("/installment/published")
//  public ResponseEntity<List<LoanInstallment>> findByPublished() {
//    try {
//      List<LoanInstallment> LoanInstallments =  loanInstallmentService.findByPublished(true);
//
//      if (LoanInstallments.isEmpty()) {
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//      }
//      return new ResponseEntity<>(LoanInstallments, HttpStatus.OK);
//    } catch (Exception e) {
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }
}
