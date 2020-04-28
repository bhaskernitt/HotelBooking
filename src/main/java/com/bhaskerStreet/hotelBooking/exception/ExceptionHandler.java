package com.bhaskerStreet.hotelBooking.exception;


import com.bhaskerStreet.hotelBooking.constants.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequest.class)
    public ResponseEntity badRequest(RootException e) {
        return sendErrorResponse(new ErrorResponseDto(e.getHttpStatus().value(),
                e.getMessage(),
                e.getErrorUrl()), e.getHttpStatus());

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Conflict.class)
    public ResponseEntity conflict(RootException e) {
        return sendErrorResponse(new ErrorResponseDto(e.getHttpStatus().value(),
                e.getMessage(),
                e.getErrorUrl()), e.getHttpStatus());

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFound.class)
    public ResponseEntity notFound(RootException e) {
        return sendErrorResponse(new ErrorResponseDto(e.getHttpStatus().value(),
                e.getMessage(),
                e.getErrorUrl()), e.getHttpStatus());

    }


    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity forAllExceptions(Exception e) {
        return sendErrorResponse(new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(),
                ErrorResponse.BAD_REQUEST.getMessage(),
                ErrorResponse.BAD_REQUEST.getCode()), HttpStatus.BAD_REQUEST);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity methodNotSupported() {
        System.out.println();
        return sendErrorResponse(new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(),
                ErrorResponse.METHOD_NOT_SUPPORTED.getMessage(),
                ErrorResponse.METHOD_NOT_SUPPORTED.getCode()), HttpStatus.BAD_REQUEST);
    }


    private ResponseEntity sendErrorResponse(ErrorResponseDto errorResponseDto, HttpStatus httpStatus) {

        return new ResponseEntity<>(errorResponseDto, httpStatus);
    }

}
