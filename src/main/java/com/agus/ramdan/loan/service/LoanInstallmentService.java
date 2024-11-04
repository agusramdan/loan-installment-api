package com.agus.ramdan.loan.service;

import com.agus.ramdan.loan.domain.LoanInstallment;
import com.agus.ramdan.loan.repository.LoanInstallmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanInstallmentService {

    @Autowired
    private LoanInstallmentRepository repository;
//  static List<LoanInstallment> loanInstallments = new ArrayList<LoanInstallment>();
//  static long id = 0;

    public List<LoanInstallment> findAll() {
        return repository.findAll();
    }

//  public List<LoanInstallment> findByTitleContaining(String title) {
//    return loanInstallments.stream().filter(LoanInstallment -> LoanInstallment.getTitle().contains(title)).collect(Collectors.toList());
//  }

    public LoanInstallment findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public LoanInstallment save(LoanInstallment loanInstallment) {
        return repository.save(loanInstallment);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

//  public List<LoanInstallment> findByPublished(boolean isPublished) {
//    return loanInstallments.stream().filter(LoanInstallment -> isPublished == LoanInstallment.isPublished()).collect(Collectors.toList());
//  }
}
