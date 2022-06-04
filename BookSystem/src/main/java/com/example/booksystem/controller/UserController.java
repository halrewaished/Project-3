package com.example.booksystem.controller;

import com.example.booksystem.DTO.Api;
import com.example.booksystem.DTO.BookDTO;
import com.example.booksystem.advice.ControllerAdviseHandler;
import com.example.booksystem.model.Book;
import com.example.booksystem.model.User;
import com.example.booksystem.repository.BookRepository;
import com.example.booksystem.repository.UserRepository;
import com.example.booksystem.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    Logger logger = LoggerFactory.getLogger(LoanController.class);


    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        logger.info("Request in get users ");
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<Api> addUsers(@RequestBody @Valid User user){
        logger.info("Request in add user ");
        userService.addUsers(user);
        return ResponseEntity.status(200).body(new Api("New user added",201));
    }

    @PostMapping("/add-user")
    public ResponseEntity<Api> addUser(@RequestBody BookDTO bookDTO){
        logger.info("Request in add user to book ");
        User user = userRepository.findById(bookDTO.getUserid()).get();
        Book book = new Book(null,bookDTO.getName(),bookDTO.getGenre(),user,null);
        user.getBooks().add(book);
        bookRepository.save(book);
        return ResponseEntity.status(200).body(new Api("New user added to book",201));
    }

}
