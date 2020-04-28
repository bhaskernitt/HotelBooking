package com.bhaskerStreet.hotelBooking.services.customerHotel;

import com.bhaskerStreet.hotelBooking.entities.CustomerHotel;
import com.bhaskerStreet.hotelBooking.repository.CustomerHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerHotelServiceImpl implements CustomerHotelService {


    @Autowired
    private CustomerHotelRepository customerHotelRepository;


    @Override
    public List<CustomerHotel> fetchAllByCustomerId(Long customerId) {

      return customerHotelRepository.findCustomerHotelByCustomerId(customerId);
    }

    @Override
    public CustomerHotel save(CustomerHotel customerHotel) {
        return customerHotelRepository.save(customerHotel);
    }
}
