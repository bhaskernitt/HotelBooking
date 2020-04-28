package com.bhaskerStreet.hotelBooking.services.customerHotel;

import com.bhaskerStreet.hotelBooking.entities.CustomerHotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerHotelService {

    List<CustomerHotel> fetchAllByCustomerId(Long customerId);

    CustomerHotel save(CustomerHotel customerHotel);
}
