package edu.miu.libraryservice.service;

import edu.miu.libraryservice.domain.Book;
import edu.miu.libraryservice.domain.Reservation;

public interface ReservationService {
    Reservation reserve(Long customerId, Book book);
}
