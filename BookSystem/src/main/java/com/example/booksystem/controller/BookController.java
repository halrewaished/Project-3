package com.example.booksystem.controller;

import com.example.booksystem.DTO.Api;
import com.example.booksystem.model.Book;
import com.example.booksystem.model.Loan;
import com.example.booksystem.repository.BookRepository;
import com.example.booksystem.repository.LoanRepository;
import com.example.booksystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;

    Logger logger = LoggerFactory.getLogger(BookController.class);


    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        logger.info("Request in get books ");
        return ResponseEntity.status(200).body(bookService.getBook());
    }

    @PostMapping
    public ResponseEntity<Api> addBook(@RequestBody @Valid Book book){
        logger.info("Request in add book ");
        bookService.addBook(book);
        return ResponseEntity.status(200).body(new Api("New book added",201));
    }


    @PostMapping("/add/{bookId}/{loanId}")
    public ResponseEntity<Api> addLoan(@PathVariable Integer bookId, @PathVariable Integer loanId){
        logger.info("Request in add loan to book ");
        Book book = bookRepository.findById(bookId).get();
        Loan loan = loanRepository.findById(loanId).get();

        book.getLoans().add(loan);
        bookRepository.save(book);

        return ResponseEntity.status(200).body(new Api("New loan added to book",201));
    }

    @PostMapping("/lend/{bookId}/{userId}")
    public ResponseEntity<Api> lendBookToUser(@PathVariable Integer bookId, @PathVariable Integer userId){
        logger.info("Request in lend book to user ");
        bookService.lendBookToUser(bookId,userId);
        return ResponseEntity.status(200).body(new Api("Lend book to user",201));
    }
}
