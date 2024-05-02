package com.useJdbc.models.Book.dao;

import java.util.List;

import com.useJdbc.models.Book.dto.BookDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BookDto> allBooks() {
        String query = "select * from book";
        List<BookDto> books = jdbcTemplate.query(query, (rs, rowNum) -> {
            return new BookDto(
                    rs.getInt("id"),
                    rs.getString("autor"),
                    rs.getString("editorial"),
                    rs.getString("nombre_libro"));
        });

        return books;
    }

    public void createBook(BookDto bookDto) {
        String query = "insert into book"
                + "(autor, editorial, nombre_libro)"
                + "values (?,?,?)";
        jdbcTemplate.update(query, bookDto.getAutor(),
                bookDto.getEditorial(), bookDto.getNombre_libro());
    }

    public void updateBook(BookDto bookDto) {
        String query = "update book "
                + "set autor = ?, editorial = ?, nombre_libro = ? where id = ?";
        jdbcTemplate.update(query, bookDto.getAutor(),
                bookDto.getEditorial(), bookDto.getNombre_libro(), bookDto.getId());
    }

    public void deleteBook(Integer id) {
        String query = "delete from book where id = ?";
        jdbcTemplate.update(query, id);
    }
}
