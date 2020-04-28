package com.bhaskerStreet.hotelBooking.controllers;


import com.bhaskerStreet.hotelBooking.process.hotel.HotelProcessService;
import com.bhaskerStreet.hotelBooking.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    private final HotelProcessService hotelProcessService;

    @Autowired
    public HotelController(HotelProcessService hotelProcessService) {
        this.hotelProcessService = hotelProcessService;
    }

    @GetMapping(value = "/hotels/{hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fetch(@PathVariable Long hotelId) {
        return hotelProcessService.processFetch(hotelId);
    }

    @GetMapping(value = "/hotels", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Hotel>> fetchAll() {
        return hotelProcessService.processFetchAll();
    }

    @DeleteMapping(value = "/hotels/{hotelId}")
    public ResponseEntity delete(@PathVariable Long hotelId) {
        return hotelProcessService.processDelete(hotelId);
    }

    @PutMapping(value = "/hotels/{hotelId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable Long hotelId) {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

}
