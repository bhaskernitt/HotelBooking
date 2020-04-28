package com.bhaskerStreet.hotelBooking.exception;

import org.springframework.http.HttpStatus;

public class Conflict extends RootException {

    public Conflict(String message, String errorUrl) {
        super(HttpStatus.CONFLICT, message, errorUrl);
    }


}
