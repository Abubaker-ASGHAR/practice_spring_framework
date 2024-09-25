package org.example;
import org.example.config.AppConfig;
import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.example.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        BookRepository bookRepository = context.getBean(BookRepository.class);

        bookRepository.addBook(new Book(1,"Spring Framework Basics",29.99));
        bookRepository.addBook(new Book(2,"Spring Framework Basics",30.99));

        OrderService orderService = context.getBean(OrderService.class);

        orderService.placeOrder(1);
        orderService.placeOrder(2);
        //orderService.placeOrder(3);


        orderService.getAllBooks();

        ((AnnotationConfigApplicationContext)context).close();



    }
}