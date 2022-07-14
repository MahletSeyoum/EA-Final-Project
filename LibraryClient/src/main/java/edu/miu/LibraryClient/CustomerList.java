package edu.miu.LibraryClient;

import lombok.Data;

import java.util.Collection;

@Data
public class CustomerList {
    public Collection<Customer> customers;
}
