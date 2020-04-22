package com.harsh.hotelBooking.services.customer;

import com.harsh.hotelBooking.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    Customer save(final Customer customer);

    Customer fetch(final Long id);

    List<Customer> fetchAll();

    void delete(final Long id);


    Customer update(final Customer customer);


}
