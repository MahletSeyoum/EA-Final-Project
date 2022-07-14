package edu.miu.BookCatalogClient;

import lombok.Data;

import java.util.Collection;

@Data
public class BookList {
    public Collection<Book> books;
}
