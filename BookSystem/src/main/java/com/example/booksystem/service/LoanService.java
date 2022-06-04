package com.example.booksystem.service;

import com.example.booksystem.exception.InvalidIdException;
import com.example.booksystem.model.Book;
import com.example.booksystem.model.Loan;
import com.example.booksystem.model.User;
import com.example.booksystem.repository.BookRepository;
import com.example.booksystem.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;


    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    public void addLoan(Loan loan) {

        loanRepository.save(loan);
    }


    public Loan lendedBook(Integer bookId) throws InvalidIdException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(
                        ()-> new InvalidIdException("Invalid Book id"));
        Loan loan = getLoans().get(bookId);

        return loan;
    }
}
