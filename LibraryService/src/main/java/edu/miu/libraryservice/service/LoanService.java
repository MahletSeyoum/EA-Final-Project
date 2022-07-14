package edu.miu.libraryservice.service;

import edu.miu.libraryservice.domain.Book;
import edu.miu.libraryservice.domain.BookCopy;
import edu.miu.libraryservice.domain.Loan;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface LoanService {
    Loan checkOut(Long customerId, BookCopy bookCopy);
    Loan returnBook(Long customerId, BookCopy bookCopy);
    Loan getLoanByBookCopyScanCode(String scanCode);
    Loan pay(Long loanId, double amount);
    List<Loan> getAllLateLoans();
}
