package edu.miu.libraryservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    private LocalDate reservationDate;
    private boolean reservationStatus;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public void addBooks(Book book){
        books.add(book);
    }
}
