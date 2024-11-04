package com.agus.ramdan.loan.repository;

import com.agus.ramdan.loan.domain.LoanSimulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanSimulationRepository extends JpaRepository<LoanSimulation, Long> {
}