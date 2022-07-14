package edu.miu.bookservice.bookcatalogservice.service;

import edu.miu.bookservice.bookcatalogservice.domain.BookCopy;
import edu.miu.bookservice.bookcatalogservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.bookservice.bookcatalogservice.domain.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void removeBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(String id, Book book) {
        Book book1 = bookRepository.findById(id).orElseGet(null);
        if(book1 != null) {
            book1.setId(id);
            book1.setIsbn(book.getIsbn());
            book1.setTitle(book.getTitle());
            book1.setAuthors(book.getAuthors());
            book1.setCopies(book.getCopies());
            return bookRepository.save(book1);
        }
        else
            return null;
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book getBookByScanCode(String scanCode) {
        return bookRepository.findByScanCode(scanCode);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public Book getBookByAuthor(String author) {
        return bookRepository.findByAuthorName(author);
    }

    @Override
    public int getBookAvailabilityCount(String id) {
        int count = 0;
        Book book = bookRepository.findById(id).get();
        List<BookCopy> copies = book.getCopies();
        for (BookCopy bc : copies){
            if (bc.isAvailable())
                count++;
        }
        return count;
    }


}
