package com.bhaskerStreet.hotelBooking.process.customer;


import com.bhaskerStreet.hotelBooking.constants.ErrorResponse;
import com.bhaskerStreet.hotelBooking.entities.customer.Customer;
import com.bhaskerStreet.hotelBooking.entities.customer.CustomerCreator;
import com.bhaskerStreet.hotelBooking.exception.Conflict;
import com.bhaskerStreet.hotelBooking.exception.NotFound;
import com.bhaskerStreet.hotelBooking.services.address.AddressService;
import com.bhaskerStreet.hotelBooking.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.bhaskerStreet.hotelBooking.constants.ErrorResponse.CONCFLICT_CUSTOMER;

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
    public ResponseEntity processCreate(com.bhaskerStreet.hotelBooking.dtos.Customer customer) throws Exception {

        Customer c = customerService.findByPhoneNumberAndEmailId(customer.getNumber(), customer.getEmailId());
        if (null != c) {
            throw new Conflict(CONCFLICT_CUSTOMER.resolveMessage(customer.getEmailId(), customer.getNumber()), CONCFLICT_CUSTOMER.getCode());

        }
        Long addressId = addressService.save(customer.getAddress()).getId();

        Customer newCustomer = new CustomerCreator.CustomerCreatorBuilder
                (customer.getName(),
                        customer.getEmailId(),
                        customer.getNumber(),
                        customer.getGender())
                .setAddressId(addressId)
                .create();

        newCustomer = customerService.save(newCustomer);

        return new ResponseEntity(newCustomer, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity processFetch(long customerId) throws Exception {

        return new ResponseEntity(customerFetcher(customerId), HttpStatus.OK);
    }

    private Customer customerFetcher(Long customerId) throws Exception {
        Customer c = customerService.fetch(customerId);

        if (null == c) {
            throw new NotFound(ErrorResponse.NOT_FOUND_CUSTOMER.resolveMessage(String.valueOf(customerId)), ErrorResponse.NOT_FOUND_CUSTOMER.getCode());
        }
        return c;
    }


    @Override
    public ResponseEntity processFetchAll() {
        return new ResponseEntity(customerService.fetchAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity processDelete(long customerId) throws Exception {
        customerFetcher(customerId);
        customerService.delete(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @Override
    public ResponseEntity processUpdate(long customerId, com.bhaskerStreet.hotelBooking.dtos.Customer customer) {
        Customer newCustomer = customerService.fetch(customerId);

        newCustomer.setPhoneNumber(customer.getNumber());
        newCustomer.setName(customer.getName());
        newCustomer.setGender(customer.getGender());
        newCustomer.setEmailId(customer.getEmailId());

        return new ResponseEntity(customerService.save(newCustomer), HttpStatus.OK);

    }
}
