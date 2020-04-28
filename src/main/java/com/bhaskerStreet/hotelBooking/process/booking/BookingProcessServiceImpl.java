package com.bhaskerStreet.hotelBooking.process.booking;

import com.bhaskerStreet.hotelBooking.entities.CustomerHotel;
import com.bhaskerStreet.hotelBooking.entities.Hotel;
import com.bhaskerStreet.hotelBooking.services.customerHotel.CustomerHotelService;
import com.bhaskerStreet.hotelBooking.services.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookingProcessServiceImpl implements BookingProcessService {


    private final CustomerHotelService customerHotelService;
    private final HotelService hotelService;

    @Autowired
    public BookingProcessServiceImpl(CustomerHotelService customerHotelService, HotelService hotelService) {
        this.customerHotelService = customerHotelService;
        this.hotelService = hotelService;
    }


    @Override
    public ResponseEntity fetchAllBookings(Long customerId) {
        return new ResponseEntity(customerHotelService.fetchAllByCustomerId(customerId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity bookHotel(Long customerId, Long hotelId) {

        Hotel hotel = hotelService.fetch(hotelId);
        hotel.setAvailable(false);

        CustomerHotel customerHotel = new CustomerHotel(customerId, hotelId);
        customerHotelService.save(customerHotel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity fetchBooking(Long customerId, Long bookingId) {
        return null;
    }
}
