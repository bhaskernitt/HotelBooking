package com.harsh.hotelBooking.services.address;

import com.harsh.hotelBooking.dtos.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {


    Address save(Address address);

    Address find(Long id);

    Address update(Address address);
}
