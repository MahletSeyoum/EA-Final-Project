package edu.miu.libraryservice.repository;

import edu.miu.libraryservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerById(Long id);
    List<Customer> findCustomerByName(String name);
    Customer findCustomerByEmail(String email);
}
