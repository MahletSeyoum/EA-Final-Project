package edu.miu.libraryservice.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String state;
    private String city;
    private String zip;
}
