package com.bhaskerStreet.hotelBooking.repository;

import com.bhaskerStreet.hotelBooking.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findAllByIsAvailable(Boolean isAvailable);
}
