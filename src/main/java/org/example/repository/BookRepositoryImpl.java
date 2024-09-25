package org.example.repository;

import org.example.entity.Book;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class BookRepositoryImpl implements BookRepository {

private final List<Book> books=new ArrayList<>();

@Override
    public void addBook(Book book) {

    books.add(book);
}

    @Override
    public Book findBookById(int id) {
    return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Book> findAllBooks() {
    return books;
    }
}
