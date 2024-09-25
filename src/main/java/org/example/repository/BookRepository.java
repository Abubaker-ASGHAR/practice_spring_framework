package org.example.repository;

import org.example.entity.Book;
import java.util.List;

public interface BookRepository {

    void addBook(Book book);
    Book findBookById(int id);
    List<Book> findAllBooks();

}
