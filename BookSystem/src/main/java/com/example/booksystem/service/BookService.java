package com.example.booksystem.service;

import com.example.booksystem.exception.InvalidIdException;
import com.example.booksystem.model.Book;
import com.example.booksystem.model.Loan;
import com.example.booksystem.model.User;
import com.example.booksystem.repository.BookRepository;
import com.example.booksystem.repository.LoanRepository;
import com.example.booksystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;

    public List<Book> getBook() {

        return bookRepository.findAll();
    }

    public void addBook(Book book) {

        bookRepository.save(book);
    }

    public void lendBookToUser(Integer bookId, Integer userId) throws InvalidIdException {
        Book book = bookRepository.findById(bookId).get();
        User user = userRepository.findById(userId).get();

        user.getBooks().add(book);
        userRepository.save(user);

        Loan loan = new Loan(null,userId,bookId,null);
        loan.getBooks().add(book);
        loanRepository.save(loan);

    }

}
