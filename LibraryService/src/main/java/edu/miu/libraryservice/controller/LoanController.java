package edu.miu.libraryservice.controller;

import edu.miu.libraryservice.domain.BookCopy;
import edu.miu.libraryservice.domain.Loan;
import edu.miu.libraryservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping("/checkout/{customerId}")
    public ResponseEntity<Loan> checkoutBook(@PathVariable("customerId") Long customerId, @RequestBody BookCopy bookCopy) {
        Loan loan = loanService.checkOut(customerId, bookCopy);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }

    @PostMapping("/return/{customerId}")
    public ResponseEntity<Loan> returnBook(@PathVariable("customerId") Long customerId, @RequestBody BookCopy bookCopy) {
        Loan loan = loanService.returnBook(customerId, bookCopy);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }

    @PostMapping("/pay/{loanId}")
    public ResponseEntity<Loan> makePayment(@PathVariable("loanId") Long loanId, @RequestParam double amount) {
        Loan loan = loanService.pay(loanId, amount);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }
}
