package com.nash.gonzoservices.Loan;

import com.nash.gonzoservices.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}