package com.bhaskerStreet.hotelBooking.constants;

public enum ErrorResponse {


    BAD_REQUEST("BAD REQUEST", "1001"),
    NOT_FOUND_CUSTOMER("Customer does not exist [%s]", "1002"),
    CONCFLICT_CUSTOMER("Customer exists [%s %s]", "1003"),


    METHOD_NOT_SUPPORTED("Incorrect method selection for the resource", "1004");



    private static final String BASE_URL = "https://bhaskerstreet.com/";
    private String message;
    private String code;


    ErrorResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return BASE_URL + code;

    }

    public String resolveMessage(String... keys) {
        return String.format(message, keys);

    }

}
