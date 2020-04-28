package com.bhaskerStreet.hotelBooking.repository;

import com.bhaskerStreet.hotelBooking.entities.CustomerHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerHotelRepository extends JpaRepository<CustomerHotel, Long> {
    List<CustomerHotel> findCustomerHotelByCustomerId(Long customerId);

}
