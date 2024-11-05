package com.agus.ramdan.loan.controller;

import com.agus.ramdan.loan.domain.LoanInfo;
import com.agus.ramdan.loan.exception.ResourceNotFoundException;
import com.agus.ramdan.loan.repository.LoanInfoRepository;
import com.agus.ramdan.loan.utils.BeanUtils;
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
    public ResponseEntity<List<LoanInfo>> getAllLoanInfos(
            @RequestParam(required = false) Long simulationId) {
        try {
            List<LoanInfo> loanInfos = loanInfoRepository.findAll();

            if (loanInfos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(loanInfos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanInfo> getLoanInfoById(@PathVariable("id") long id)
            throws ResourceNotFoundException {
        LoanInfo loanInfo = loanInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan Info not found for this id :: " + id));
        return ResponseEntity.ok().body(loanInfo);
    }

    @PostMapping("")
    public ResponseEntity<LoanInfo> createLoanInfo(@RequestBody LoanInfo loanInfo) {
        try {
            LoanInfo _loanInfo = loanInfoRepository.save(loanInfo);
            return ResponseEntity.status(HttpStatus.CREATED).body(_loanInfo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
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
    public ResponseEntity<HttpStatus> deleteLoanInfo(@PathVariable("id") long id) {
        try {
            loanInfoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<HttpStatus> deleteAllLoanInfos() {
        try {
            loanInfoRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//  @GetMapping("/published")
//  public ResponseEntity<List<LoanInfo>> findByPublished() {
//    try {
//      List<LoanInfo> LoanInfos =  loanInfoService.findByPublished(true);
//
//      if (LoanInfos.isEmpty()) {
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//      }
//      return new ResponseEntity<>(LoanInfos, HttpStatus.OK);
//    } catch (Exception e) {
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }
}
