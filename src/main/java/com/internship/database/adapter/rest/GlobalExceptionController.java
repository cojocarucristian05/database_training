package com.internship.database.adapter.rest;

import com.internship.database.domain.exceptions.CustomerNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class GlobalExceptionController {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> exception(CustomerNotFoundException customerNotFoundException) {
        log.error(customerNotFoundException.getMessage(), customerNotFoundException);
        return new ResponseEntity<>(customerNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
