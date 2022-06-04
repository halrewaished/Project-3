package com.example.booksystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Book {

    @Id
    //@NotNull(message = "Id is required !")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name is required !")
    private String name;
    @NotEmpty(message = "Genre is required !")
    private String genre;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Loan> loans;
}
