package edu.miu.libraryservice.repository;

import edu.miu.libraryservice.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Loan findLoanByBookCopy_ScanCode(String scanCode);
    Loan findLoanById(Long loanId);
    @Query(value = "SELECT l FROM Loan l where l.returnDate > l.dueDate")
    List<Loan> findAllLateLoans();
}
