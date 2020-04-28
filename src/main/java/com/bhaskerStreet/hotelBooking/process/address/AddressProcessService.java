package com.bhaskerStreet.hotelBooking.process.address;

import com.bhaskerStreet.hotelBooking.dtos.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AddressProcessService {

    ResponseEntity fetchProcess(Long customerId, Long addressId);

    ResponseEntity updateProcess(Long customerId, Long addressId,Address address);

}
