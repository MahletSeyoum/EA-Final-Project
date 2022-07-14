package edu.miu.BookCatalogClient;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Book {
    private String id;
    private String isbn;
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<BookCopy> copies = new ArrayList<>();

    public Book() {
    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public void addAuthor(Author authorRequest) {
        authors.add(authorRequest);
    }

    public void addBookCopy(BookCopy copyRequest) {
        copies.add(copyRequest);
    }
}
