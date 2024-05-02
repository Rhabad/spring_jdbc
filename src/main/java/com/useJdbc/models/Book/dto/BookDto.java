package com.useJdbc.models.Book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookDto {
    private Integer id;
    private String autor;
    private String editorial;
    private String nombre_libro;
}
