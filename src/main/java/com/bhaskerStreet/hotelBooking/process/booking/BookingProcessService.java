package com.bhaskerStreet.hotelBooking.process.booking;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface BookingProcessService {

    ResponseEntity fetchAllBookings(Long customerId);

    ResponseEntity bookHotel(Long customerId, Long hotelId);

    ResponseEntity fetchBooking(Long customerId, Long bookingId);
}
