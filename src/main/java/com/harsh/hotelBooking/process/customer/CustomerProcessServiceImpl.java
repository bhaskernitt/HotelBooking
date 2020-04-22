package com.harsh.hotelBooking.process.customer;


import com.harsh.hotelBooking.dtos.Customer;
import com.harsh.hotelBooking.services.address.AddressService;
import com.harsh.hotelBooking.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerProcessServiceImpl implements CustomerProcessService {


    private final CustomerService customerService;
    private final AddressService addressService;


    @Autowired
    public CustomerProcessServiceImpl(CustomerService customerService, AddressService addressService) {
        this.customerService = customerService;
        this.addressService = addressService;
    }

    @Override
    public ResponseEntity processCreate(Customer customer) {

        //
        Long addressId = addressService.save(customer.getAddress()).getId();
        com.harsh.hotelBooking.entities.Customer newCustomer = new com.harsh.hotelBooking.entities.Customer();

        newCustomer.setPhoneNumber(customer.getNumber());
        newCustomer.setName(customer.getName());
        newCustomer.setGender(customer.getGender());
        newCustomer.setEmailId(customer.getEmailId());
        newCustomer.setAddressId(addressId);

        newCustomer = customerService.save(newCustomer);

        newCustomer.setAddressId(addressId);

        return new ResponseEntity(newCustomer, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity processFetch(long customerId) {
        return new ResponseEntity(customerService.fetch(customerId), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity processFetchAll() {
        return new ResponseEntity(customerService.fetchAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity processDelete(long customerId) {
        customerService.delete(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @Override
    public ResponseEntity processUpdate(long customerId, Customer customer) {
        com.harsh.hotelBooking.entities.Customer newCustomer = customerService.fetch(customerId);


        newCustomer.setPhoneNumber(customer.getNumber());
        newCustomer.setName(customer.getName());
        newCustomer.setGender(customer.getGender());
        newCustomer.setEmailId(customer.getEmailId());

        return new ResponseEntity(customerService.save(newCustomer), HttpStatus.OK);

    }
}
