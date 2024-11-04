package com.agus.ramdan.loan.controller;

import com.agus.ramdan.loan.domain.LoanSimulation;
import com.agus.ramdan.loan.service.LoanSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/loan")
public class LoanSimulationController {
    @Autowired
    LoanSimulationService loanSimulationService;

    @GetMapping("/simulation")
    public ResponseEntity<List<LoanSimulation>> getAllLoanSimulations(@RequestParam(required = false) String title) {
        try {
            List<LoanSimulation> loanSimulations = new ArrayList<LoanSimulation>();

//      if (title == null)
//        loanSimulationService.findAll().forEach(LoanSimulations::add);
//      else
//        loanSimulationService.findByTitleContaining(title).forEach(LoanSimulations::add);

            if (loanSimulations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(loanSimulations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/simulation/{id}")
    public ResponseEntity<LoanSimulation> getLoanSimulationById(@PathVariable("id") long id) {
        LoanSimulation loanSimulation = loanSimulationService.findById(id);

        if (loanSimulation != null) {
            return new ResponseEntity<>(loanSimulation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/simulation")
    public ResponseEntity<LoanSimulation> createLoanSimulation(@RequestBody LoanSimulation loanSimulation) {
        try {
            LoanSimulation _loanSimulation = loanSimulationService.save(loanSimulation);
            return new ResponseEntity<>(_loanSimulation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/simulation/{id}")
    public ResponseEntity<LoanSimulation> updateLoanSimulation(@PathVariable("id") long id,
                                                               @RequestBody LoanSimulation _loanSimulation) {
        LoanSimulation loanSimulation = loanSimulationService.findById(id);

        if (loanSimulation != null) {
//      _LoanSimulation.setTitle(LoanSimulation.getTitle());
//      _LoanSimulation.setDescription(LoanSimulation.getDescription());
//      _LoanSimulation.setPublished(LoanSimulation.isPublished());
            loanSimulationService.save(loanSimulation);
            return new ResponseEntity<>(loanSimulation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/simulation/{id}")
    public ResponseEntity<HttpStatus> deleteLoanSimulation(@PathVariable("id") long id) {
        try {
            loanSimulationService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/simulation")
    public ResponseEntity<HttpStatus> deleteAllLoanSimulations() {
        try {
            loanSimulationService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

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
