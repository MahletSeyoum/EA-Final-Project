package edu.miu.libraryservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String id;
    private String isbn;
    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<BookCopy> copies = new ArrayList<>();

    public void addBookCopy (BookCopy bookCopy) {
        copies.add(bookCopy);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }
}
