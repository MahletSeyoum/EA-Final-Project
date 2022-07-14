package edu.miu.LibraryClient;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {
    private Long id;
    private String name;
    private String email;
    private Address address;
    private List<Loan> loans = new ArrayList<>();
}
