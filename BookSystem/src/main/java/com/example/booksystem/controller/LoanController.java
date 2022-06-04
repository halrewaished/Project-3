package com.example.booksystem.controller;

import com.example.booksystem.DTO.Api;
import com.example.booksystem.advice.ControllerAdviseHandler;
import com.example.booksystem.model.Loan;
import com.example.booksystem.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/loan")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    Logger logger = LoggerFactory.getLogger(LoanController.class);


    @GetMapping
    public ResponseEntity<List<Loan>> getLoans(){
        logger.info("Request in get loans ");
        return ResponseEntity.status(200).body(loanService.getLoans());
    }

    @PostMapping
    public ResponseEntity<Api> addLoans(@RequestBody @Valid Loan loan){
        logger.info("Request in add loans ");
        loanService.addLoan(loan);
        return ResponseEntity.status(200).body(new Api("New loan added",201));
    }

    @PostMapping("/lend/{bookId}")
    public ResponseEntity<Api> lendedBooks(@PathVariable Integer bookId){
        logger.info("Request in lended book ");
        loanService.lendedBook(bookId);
        return ResponseEntity.status(200).body(new Api("Lended books",201));
    }
}
