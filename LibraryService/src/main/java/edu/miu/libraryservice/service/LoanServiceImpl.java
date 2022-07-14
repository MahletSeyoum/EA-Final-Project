package edu.miu.libraryservice.service;

import edu.miu.libraryservice.domain.*;
import edu.miu.libraryservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    RestTemplate restTemplate;

    private String urlBook = "http://localhost:8080/books";
    private String urlCustomer = "http://localhost:8080/customers";

    @Override
    public Loan checkOut(Long customerId, BookCopy bookCopy) {
        Book book = restTemplate.getForObject(urlBook + "/book-copy/" + bookCopy.getScanCode(), Book.class);
        Customer customer = restTemplate.getForObject(urlCustomer + "?id=" + customerId, Customer.class);
        Loan loan = new Loan();
        loan.setStartDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusWeeks(3));
        loan.setBookCopy(bookCopy);
        loan.setCustomer(customer);
        loan.addBook(book);
        int index = book.getCopies().indexOf(bookCopy);
        book.getCopies().get(index).setAvailable(false);
        restTemplate.put(urlBook + "/" + book.getId(), Book.class);
        return loanRepository.save(loan);
    }

    @Override
    public Loan returnBook(Long customerId, BookCopy bookCopy) {
        Book book = restTemplate.getForObject(urlBook + "/book-copy/" + bookCopy.getScanCode(), Book.class);
        Loan loan = loanRepository.findLoanByBookCopy_ScanCode(bookCopy.getScanCode());
        int index = book.getCopies().indexOf(bookCopy);
        book.getCopies().get(index).setAvailable(true);
        restTemplate.put(urlBook + "/" + book.getId(), Book.class);
        loan.setReturnDate(LocalDate.now());
        if(loan.getReturnDate().isAfter(loan.getDueDate())){
            long diffInDays = ChronoUnit.DAYS.between(loan.getDueDate(), loan.getReturnDate());
            double amount = diffInDays * 0.5;
            loan.setLateFee(amount);
            loan.setOutstandingBalance(amount);
        }
        return loanRepository.save(loan);
    }

    @Override
    public Loan getLoanByBookCopyScanCode(String scanCode) {
        return loanRepository.findLoanByBookCopy_ScanCode(scanCode);
    }

    @Override
    public Loan pay(Long loanId, double amount) {
        Loan loan = loanRepository.findLoanById(loanId);
        double paymentAmount = loan.getLateFee();
        double balance = paymentAmount - amount;
        loan.setOutstandingBalance(balance);
        System.out.println(loan.getCustomer().getName() + " Paid $" + amount + " for late fee with outstanding balance of " + balance);
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getAllLateLoans() {
        return loanRepository.findAllLateLoans();
    }
}
