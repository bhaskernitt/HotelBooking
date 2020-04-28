package com.bhaskerStreet.hotelBooking.controllers;


import com.bhaskerStreet.hotelBooking.process.booking.BookingProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerBookingController {

    private final BookingProcessService bookingProcessService;

    @Autowired
    public CustomerBookingController(BookingProcessService bookingProcessService) {
        this.bookingProcessService = bookingProcessService;
    }


    @GetMapping(value = "/customers/{customerId}/hotels", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity bookedHotels(@PathVariable Long customerId) {
        return bookingProcessService.fetchAllBookings(customerId);

    }

    @PostMapping("/customers/{customerId}/hotels/{hotelId}")
    public ResponseEntity bookHotel(@PathVariable Long customerId,@PathVariable Long hotelId) {
        return bookingProcessService.bookHotel(customerId, hotelId);

    }


    @GetMapping(value = "/customers/{customerId}/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fetchAllBookings(@PathVariable Long customerId) {

        return bookingProcessService.fetchAllBookings(customerId);

    }



    @GetMapping(value = "/customers/{customerId}/bookings/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fetchBooking(@PathVariable Long customerId, @PathVariable Long bookingId) {

        return bookingProcessService.fetchBooking(customerId, bookingId);
    }


}
