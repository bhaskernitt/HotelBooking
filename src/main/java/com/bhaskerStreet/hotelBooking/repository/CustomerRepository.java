package com.bhaskerStreet.hotelBooking.repository;


import com.bhaskerStreet.hotelBooking.entities.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByPhoneNumberAndEmailId(String phoneNumber,String emailId);

}
