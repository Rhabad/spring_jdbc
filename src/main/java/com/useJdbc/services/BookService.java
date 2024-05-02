package com.useJdbc.services;

import com.useJdbc.models.Book.dao.BookDao;
import com.useJdbc.models.Book.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<BookDto> allBoks() {
        return bookDao.allBooks();
    }

    public void createBook(BookDto bookDto) {
        bookDao.createBook(bookDto);
    }

    public void updateBook(BookDto bookDto) {
        bookDao.updateBook(bookDto);
    }

    public void deleteBook(Integer id) {
        bookDao.deleteBook(id);
    }
}
