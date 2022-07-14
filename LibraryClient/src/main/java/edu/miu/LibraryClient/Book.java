package edu.miu.LibraryClient;

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

    public void addBookCopy (BookCopy bookCopy) {
        copies.add(bookCopy);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }
}

