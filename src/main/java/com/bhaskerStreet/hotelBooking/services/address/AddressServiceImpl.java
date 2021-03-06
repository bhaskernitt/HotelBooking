package com.bhaskerStreet.hotelBooking.services.address;

import com.bhaskerStreet.hotelBooking.dtos.Address;
import com.bhaskerStreet.hotelBooking.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {


    private final AddressRepository addressRepository;


    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address find(Long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

}
