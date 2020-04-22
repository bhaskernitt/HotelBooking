package com.harsh.hotelBooking.controllers;


import com.harsh.hotelBooking.dtos.Customer;
import com.harsh.hotelBooking.process.customer.CustomerProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {


    private final CustomerProcessService customerProcessService;


    @Autowired
    public CustomerController(CustomerProcessService customerProcessService) {
        this.customerProcessService = customerProcessService;
    }

    @PostMapping(value = "/customer",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE

    )
    public ResponseEntity create(@RequestBody Customer customer) {

        return customerProcessService.processCreate(customer);

    }

    @GetMapping(value = "/customers/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity Fetch(@PathVariable long customerId) {
        return customerProcessService.processFetch(customerId);

    }

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity FetchAll() {

        return customerProcessService.processFetchAll();

    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity delete(@PathVariable long customerId) {
        return customerProcessService.processDelete(customerId);

    }

    @PutMapping("/customers/{customerId}")
    public ResponseEntity Update(@PathVariable long customerId, @RequestBody Customer customer) {

        return customerProcessService.processUpdate(customerId, customer);

    }


}
