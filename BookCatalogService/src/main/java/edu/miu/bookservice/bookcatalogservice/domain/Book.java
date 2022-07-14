package edu.miu.bookservice.bookcatalogservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
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
