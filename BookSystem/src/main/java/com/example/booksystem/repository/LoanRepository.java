package com.example.booksystem.repository;

import com.example.booksystem.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Integer> {
}
