package edu.miu.bookservice.bookcatalogservice.service;

import edu.miu.bookservice.bookcatalogservice.domain.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();
    Book addBook(Book book);
    void removeBook(String id);
    Book updateBook(String id, Book book);
    Optional<Book> getBookById(String id);
    Book getBookByScanCode(String scanCode);
    Book getBookByTitle(String title);
    Book getBookByAuthor(String author);
    int getBookAvailabilityCount(String id);
}
