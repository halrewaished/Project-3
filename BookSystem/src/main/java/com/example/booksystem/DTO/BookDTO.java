package com.example.booksystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class BookDTO {

    private Integer userid;
    private String name;
    private String genre;
}
