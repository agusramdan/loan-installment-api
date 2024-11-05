package com.agus.ramdan.loan.controller;

import com.agus.ramdan.loan.domain.LoanInfo;
import com.agus.ramdan.loan.exception.ResourceNotFoundException;
import com.agus.ramdan.loan.repository.LoanInfoRepository;
import com.agus.ramdan.loan.utils.BeanUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan/info")
public class LoanInfoController {

    @Autowired
    LoanInfoRepository loanInfoRepository;

    @GetMapping("")
    @ApiOperation(value = "Get All Loan Info",
            response = List.class)
    public ResponseEntity<List<LoanInfo>> getAllLoanInfos() {
        List<LoanInfo> loanInfos = loanInfoRepository.findAll();
        if (loanInfos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(loanInfos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Loan Info",
            response = LoanInfo.class)
    public ResponseEntity<LoanInfo> getLoanInfoById(@PathVariable("id") long id)
            throws ResourceNotFoundException {
        LoanInfo loanInfo = loanInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan Info not found for this id :: " + id));
        return ResponseEntity.ok().body(loanInfo);
    }

    @PostMapping("")
    @ApiOperation(value = "Create Loan Info",
            response = LoanInfo.class)
    public ResponseEntity<LoanInfo> createLoanInfo(@RequestBody LoanInfo loanInfo) {
        LoanInfo _loanInfo = loanInfoRepository.save(loanInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(_loanInfo);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Loan Info",
            response = LoanInfo.class)
    public ResponseEntity<LoanInfo> updateLoanInfo(
            @PathVariable("id") long id,
            @RequestBody LoanInfo _loanInfo)
            throws ResourceNotFoundException {
        LoanInfo loanInfo = loanInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan Info not found for this id :: " + id));
        BeanUtils.copyNonNullProperties(_loanInfo, loanInfo);
        loanInfo = loanInfoRepository.save(loanInfo);
        return ResponseEntity.ok().body(loanInfo);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Loan Info By Id")
    public ResponseEntity<HttpStatus> deleteLoanInfo(@PathVariable("id") long id) {
        loanInfoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
