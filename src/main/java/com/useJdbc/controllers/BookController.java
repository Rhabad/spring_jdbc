package com.useJdbc.controllers;

import com.useJdbc.models.Book.dto.BookDto;
import com.useJdbc.services.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("books")
    public List<BookDto> getBooks() {
        return bookService.allBoks();
    }

    @PostMapping("book")
    public String createBook(@RequestBody BookDto bookDto) {
        bookService.createBook(bookDto);
        return "guardao perrin";
    }

    @PutMapping("book")
    public String updateBook(@RequestBody BookDto bookDto) {
        bookService.updateBook(bookDto);
        return "actualizao perrin";
    }

    @DeleteMapping("book/{id}")
    public String updateBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return "deletea perrin";
    }

}
