package com.bhaskerStreet.hotelBooking.services.hotel;

import com.bhaskerStreet.hotelBooking.repository.HotelRepository;
import com.bhaskerStreet.hotelBooking.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> fetchAll() {

        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> fetchAllAvailableHotels() {
        return hotelRepository.findAllByIsAvailable(true);
    }

    @Override
    public Hotel fetch(Long hotelId) {
        return hotelRepository.findById(hotelId).orElse(null);
    }

    @Override
    public void delete(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public Hotel update(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
