package com.example.boottest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException( ApiRequestException e ) {

        ZoneId zone = ZoneId.systemDefault();
        ApiRequestExceptionPayload payload = new ApiRequestExceptionPayload(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of(zone.getId()))
        );

        return new ResponseEntity<Object>(payload, HttpStatus.BAD_REQUEST);


    }

}
