package com.harsh.hotelBooking.process.customer;


import com.harsh.hotelBooking.dtos.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CustomerProcessService {

    ResponseEntity processCreate(final com.harsh.hotelBooking.dtos.Customer customer);

    ResponseEntity processFetch(final long customerId);

    ResponseEntity processFetchAll();

    ResponseEntity processDelete(final long customerId);

    ResponseEntity processUpdate(final long customerId, final Customer customer);


}
