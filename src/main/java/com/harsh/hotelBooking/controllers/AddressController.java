package com.harsh.hotelBooking.controllers;

import com.harsh.hotelBooking.dtos.Address;
import com.harsh.hotelBooking.process.address.AddressProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {


    private final AddressProcessService addressProcessService;


    @Autowired
    public AddressController(AddressProcessService addressProcessService) {
        this.addressProcessService = addressProcessService;
    }

    @GetMapping(value = "/customers/{customerId}/addresses/{addressId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fetch(@PathVariable Long customerId, @PathVariable Long addressId) {

        return addressProcessService.fetchProcess(customerId, addressId);

    }


    @PutMapping(value = "/customers/{customerId}/addresses/{addressId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable Long customerId, @PathVariable Long addressId, @RequestBody Address address) {
        return addressProcessService.updateProcess(customerId, addressId, address);

    }


}
