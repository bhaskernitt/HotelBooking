package com.bhaskerStreet.hotelBooking.process.hotel;

import com.bhaskerStreet.hotelBooking.entities.Hotel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelProcessService {
    ResponseEntity<List<Hotel>> processFetchAll();

    ResponseEntity<Hotel> processFetch(Long hotelId);

    ResponseEntity processDelete(Long hotelId);
}
