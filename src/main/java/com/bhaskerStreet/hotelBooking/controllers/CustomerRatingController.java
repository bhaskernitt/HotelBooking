package com.bhaskerStreet.hotelBooking.controllers;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRatingController {


    @PatchMapping(value = "/customers/{customerId}/bookings/{bookingId}/rating", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fetchAllBookings(@PathVariable Long customerId,@PathVariable Long bookingId) {

        return null;

    }


}
