package com.bhaskerStreet.hotelBooking.services.customer;

import com.bhaskerStreet.hotelBooking.entities.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    Customer save(final Customer customer);

    Customer fetch(final Long id);

    List<Customer> fetchAll();

    void delete(final Long id);

    Customer findByPhoneNumberAndEmailId(String phoneNumber,String emailId);

    Customer update(final Customer customer);


}
