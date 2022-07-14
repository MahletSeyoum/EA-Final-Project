package edu.miu.bookservice.bookcatalogservice.controller;

import edu.miu.bookservice.bookcatalogservice.domain.Book;
import edu.miu.bookservice.bookcatalogservice.domain.BookCopy;
import edu.miu.bookservice.bookcatalogservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book book1 = bookService.addBook(book);
        return new ResponseEntity<>(book1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable("id") String id) {
        bookService.removeBook(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book) {
        Book book1 = bookService.updateBook(id, book);
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable("id") String id) {
        Optional<Book> book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/book-copy/{scanCode}")
    public ResponseEntity<Book> getBookByScanCode(@PathVariable("scanCode")String code) {
        Book book = bookService.getBookByScanCode(code);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable("title")String title) {
        Book book = bookService.getBookByTitle(title);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

//    @GetMapping("/checkout/{id}")
//    public ResponseEntity<Book> checkOutBookById(@PathVariable("id") String id) {
//        Book book = bookService.getBookById(id).get();
//
////        book.getCopies().get().isAvailable();
//        return new ResponseEntity<>(book, HttpStatus.OK);
//    }

    @GetMapping("/author/{author}")
    public ResponseEntity<Book> getBookByAuthor(@PathVariable String author) {
        Book book = bookService.getBookByAuthor(author);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/count/{id}")
    public int getBookAvailabilityCount(@PathVariable String id) {
        return bookService.getBookAvailabilityCount(id);
    }
}
