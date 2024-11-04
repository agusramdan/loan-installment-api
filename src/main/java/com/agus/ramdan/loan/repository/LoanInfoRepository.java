package com.agus.ramdan.loan.repository;

import com.agus.ramdan.loan.domain.LoanInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanInfoRepository extends JpaRepository<LoanInfo, Long> {
}