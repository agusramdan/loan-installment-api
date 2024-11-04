package com.agus.ramdan.loan.repository;

import com.agus.ramdan.loan.domain.LoanInstallment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanInstallmentRepository extends JpaRepository<LoanInstallment, Long> {
}