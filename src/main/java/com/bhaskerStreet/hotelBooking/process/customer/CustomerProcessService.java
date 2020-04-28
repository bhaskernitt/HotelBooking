package com.bhaskerStreet.hotelBooking.process.customer;


import com.bhaskerStreet.hotelBooking.dtos.Customer;
import com.bhaskerStreet.hotelBooking.exception.BadRequest;
import com.bhaskerStreet.hotelBooking.exception.Conflict;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CustomerProcessService {

    ResponseEntity processCreate(final Customer customer) throws Exception;

    ResponseEntity processFetch(final long customerId) throws Exception;

    ResponseEntity processFetchAll();

    ResponseEntity processDelete(final long customerId) throws Exception;

    ResponseEntity processUpdate(final long customerId, final Customer customer);


}
