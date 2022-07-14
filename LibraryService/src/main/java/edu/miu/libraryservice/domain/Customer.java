package edu.miu.libraryservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    @Embedded
    private Address address;
    @OneToMany(cascade = CascadeType.ALL)
    List<Loan> loans = new ArrayList<>();
}
