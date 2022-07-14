package edu.miu.libraryservice.service;

import edu.miu.libraryservice.domain.Book;
import edu.miu.libraryservice.domain.Reservation;
import edu.miu.libraryservice.repository.CustomerRepository;
import edu.miu.libraryservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Reservation reserve(Long customerId, Book book) {
        Reservation reservation = new Reservation();
        reservation.setReservationDate(LocalDate.now());
        reservation.setCustomer(customerRepository.findCustomerById(customerId));
        reservation.setReservationStatus(true);
        reservation.addBooks(book);
        return reservation;
    }


}
