package com.bhaskerStreet.hotelBooking.repository;

import com.bhaskerStreet.hotelBooking.dtos.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {


}
