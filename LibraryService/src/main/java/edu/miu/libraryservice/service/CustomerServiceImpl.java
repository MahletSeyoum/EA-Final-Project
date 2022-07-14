package edu.miu.libraryservice.service;

import edu.miu.libraryservice.domain.Book;
import edu.miu.libraryservice.domain.Customer;
import edu.miu.libraryservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://localhost:8080/books";

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public List<Customer> getCustomerByName(String name) {
        return customerRepository.findCustomerByName(name);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    @Override
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @Override
    public Book checkOut(String id) {
        Book book = restTemplate.getForObject(url + id, Book.class);

        return book;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer customer1 = customerRepository.findCustomerById(id);
        if(customer1 != null) {
            customer1.setId(id);
            customer1.setName(customer.getName());
            customer1.setEmail(customer.getEmail());
            customer1.setAddress(customer.getAddress());
            return customerRepository.save(customer1);
        }
        else
            return null;
    }



}
