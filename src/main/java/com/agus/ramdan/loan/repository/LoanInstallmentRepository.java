package com.agus.ramdan.loan.repository;

import com.agus.ramdan.loan.domain.LoanInstallment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanInstallmentRepository extends JpaRepository<LoanInstallment, Long> {
    List<LoanInstallment> findAllByInfoId(Long infoId, Sort var1);
}