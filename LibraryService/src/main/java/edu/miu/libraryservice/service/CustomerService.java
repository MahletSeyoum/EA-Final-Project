package edu.miu.libraryservice.service;

import edu.miu.libraryservice.domain.Book;
import edu.miu.libraryservice.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer getCustomerById(Long id);
    List<Customer> getCustomerByName(String name);
    Customer getCustomerByEmail(String email);
    Customer addCustomer(Customer customer);
    void deleteCustomer(Long id);
    Customer updateCustomer(Long id, Customer customer);
    List<Customer> getAllCustomers();
    Book checkOut(String code);
}
