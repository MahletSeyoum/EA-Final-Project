package edu.miu.libraryservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate startDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double lateFee;
    private double outstandingBalance;
    @ManyToOne
    private BookCopy bookCopy;
    @ManyToOne
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }
}
