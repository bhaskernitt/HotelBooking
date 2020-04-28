package com.bhaskerStreet.hotelBooking.services.hotel;

import com.bhaskerStreet.hotelBooking.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    List<Hotel> fetchAll();

    List<Hotel> fetchAllAvailableHotels();

    Hotel fetch(Long hotelId);

    void delete(Long hotelId);

    Hotel update(Hotel hotel);


}
