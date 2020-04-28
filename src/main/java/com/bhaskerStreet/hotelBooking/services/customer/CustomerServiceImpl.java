package com.bhaskerStreet.hotelBooking.services.customer;

import com.bhaskerStreet.hotelBooking.entities.customer.Customer;
import com.bhaskerStreet.hotelBooking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Customer save(final Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public Customer fetch(final Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> fetchAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(final Long id) {
        customerRepository.deleteById(id);

    }

    @Override
    public Customer findByPhoneNumberAndEmailId(String phoneNumber, String emailId) {
        return customerRepository.findByPhoneNumberAndEmailId(phoneNumber, emailId);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }
}
