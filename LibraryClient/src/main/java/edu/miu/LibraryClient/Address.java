package edu.miu.LibraryClient;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String state;
    private String city;
    private String zip;
}