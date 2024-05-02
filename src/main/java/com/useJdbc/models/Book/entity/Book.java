package com.useJdbc.models.Book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor @NoArgsConstructor
public class Book {
    private Integer id;
    private String autor;
    private String editorial;
    private String nombre_libro;
}
