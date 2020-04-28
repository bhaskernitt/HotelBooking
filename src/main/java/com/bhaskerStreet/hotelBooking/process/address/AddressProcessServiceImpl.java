package com.bhaskerStreet.hotelBooking.process.address;

import com.bhaskerStreet.hotelBooking.dtos.Address;
import com.bhaskerStreet.hotelBooking.services.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressProcessServiceImpl implements AddressProcessService {

    private final AddressService addressService;


    @Autowired
    public AddressProcessServiceImpl(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public ResponseEntity fetchProcess(Long customerId, Long addressId) {
        //custumer id is not getting used as of now
        return new ResponseEntity(addressService.find(addressId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateProcess(Long customerId, Long addressId, Address address) {
        Address newAddress = addressService.find(addressId);
        newAddress.setCity(address.getCity());
        newAddress.setCountry(address.getCountry());
        newAddress.setStreet(address.getStreet());

        addressService.update(newAddress);

        return new ResponseEntity(newAddress, HttpStatus.OK);

    }
}
