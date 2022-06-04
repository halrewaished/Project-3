package com.example.booksystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Loan {

    @Id
    @NotNull(message = "Id is required !")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "User id is required !")
    private Integer userId;
    @NotNull(message = "Book id is required !")
    private Integer bookId;


    @ManyToMany(mappedBy = "loans", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book> books;
}
