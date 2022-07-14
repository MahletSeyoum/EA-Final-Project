package edu.miu.LibraryClient;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Loan {
    private Long id;
    private LocalDate startDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double lateFee;
    private double outstandingBalance;
    BookCopy bookCopy;
    Customer customer;
    List<Book> books = new ArrayList<>();
}
