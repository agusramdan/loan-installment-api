package com.agus.ramdan.loan.service;

import com.agus.ramdan.loan.domain.LoanSimulation;
import com.agus.ramdan.loan.repository.LoanSimulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanSimulationService {

    @Autowired
    private LoanSimulationRepository repository;
//  static List<LoanSimulation> loanSimulations = new ArrayList<LoanSimulation>();
//  static long id = 0;

    public List<LoanSimulation> findAll() {
        return repository.findAll();
    }

//  public List<LoanSimulation> findByTitleContaining(String title) {
//    return loanSimulations.stream().filter(LoanSimulation -> LoanSimulation.getTitle().contains(title)).collect(Collectors.toList());
//  }

    public LoanSimulation findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public LoanSimulation save(LoanSimulation loanSimulation) {
        return repository.save(loanSimulation);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

//  public List<LoanSimulation> findByPublished(boolean isPublished) {
//    return loanSimulations.stream().filter(LoanSimulation -> isPublished == LoanSimulation.isPublished()).collect(Collectors.toList());
//  }
}
