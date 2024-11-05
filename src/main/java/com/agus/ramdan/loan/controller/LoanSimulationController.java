package com.agus.ramdan.loan.controller;

import com.agus.ramdan.loan.domain.LoanSimulation;
import com.agus.ramdan.loan.exception.ResourceNotFoundException;
import com.agus.ramdan.loan.repository.LoanSimulationRepository;
import com.agus.ramdan.loan.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
//@RestController
//@RequestMapping("/api/loan")
public class LoanSimulationController {
    @Autowired
    LoanSimulationRepository loanSimulationRepository;

    @GetMapping("/simulation")
    public ResponseEntity<List<LoanSimulation>> getAllLoanSimulations(@RequestParam(required = false) String title) {
        try {
            List<LoanSimulation> loanSimulations = loanSimulationRepository.findAll();
            if (loanSimulations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(loanSimulations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/simulation/{id}")
    public ResponseEntity<LoanSimulation> getLoanSimulationById(@PathVariable("id") long id)
            throws ResourceNotFoundException {
        LoanSimulation loanSimulation = loanSimulationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan Simulation not found for this id :: " + id));
        if (loanSimulation != null) {
            return new ResponseEntity<>(loanSimulation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/simulation")
    public ResponseEntity<LoanSimulation> createLoanSimulation(@RequestBody LoanSimulation loanSimulation) {
        try {
            LoanSimulation _loanSimulation = loanSimulationRepository.save(loanSimulation);
            return new ResponseEntity<>(_loanSimulation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/simulation/{id}")
    public ResponseEntity<LoanSimulation> updateLoanSimulation(
            @PathVariable("id") long id,
            @RequestBody LoanSimulation _loanSimulation)
            throws ResourceNotFoundException {
        LoanSimulation loanSimulation = loanSimulationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan Installment not found for this id :: " + id));
        BeanUtils.copyNonNullProperties(_loanSimulation, loanSimulation);
        loanSimulation = loanSimulationRepository.save(loanSimulation);
        return ResponseEntity.ok().body(loanSimulation);
    }

    @DeleteMapping("/simulation/{id}")
    public ResponseEntity<HttpStatus> deleteLoanSimulation(@PathVariable("id") long id) {
        try {
            loanSimulationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @DeleteMapping("/simulation")
//    public ResponseEntity<HttpStatus> deleteAllLoanSimulations() {
//        try {
//            loanSimulationService.deleteAll();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }

//  @GetMapping("/simulation/published")
//  public ResponseEntity<List<LoanSimulation>> findByPublished() {
//    try {
//      List<LoanSimulation> LoanSimulations =  loanSimulationService.findByPublished(true);
//
//      if (LoanSimulations.isEmpty()) {
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//      }
//      return new ResponseEntity<>(LoanSimulations, HttpStatus.OK);
//    } catch (Exception e) {
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }
}
