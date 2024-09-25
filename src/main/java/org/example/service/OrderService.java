package org.example.service;

import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {

    private final BookRepository bookRepository;
    public final DiscountService discountService;

    @Autowired
    public OrderService(BookRepository bookRepository, DiscountService discountService) {
        this.bookRepository = bookRepository;
        this.discountService = discountService;
    }

    public void placeOrder(int bookId) {
        Book book =bookRepository.findBookById(bookId);
        if(book!=null) {
            double discount= discountService.calculateDiscount(book.getPrice());
            double finalPrice = book.getPrice()-discount;

            System.out.println(finalPrice);
        }
        else {
            System.out.println("Book not found");
        }
    }

    public void getAllBooks() {
        List<Book> books = bookRepository.findAllBooks();
        books.stream().forEach(System.out::println);
    }
}
