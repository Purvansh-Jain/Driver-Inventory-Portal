package com.driverinventoryportal.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class AdviceController {
    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    Map<String, String> showCustomMessage(Exception e) {
        Map<String,String> response = new HashMap<>();
        response.put("Data Validation Error : ","Please check data fields for Communication Protocol / Driver Type / Model / Vendor and enter valid input for them as they are mandatory fields");
        return response;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException)
    {
        return new ResponseEntity<String>("No Record Found with Given Id, Please change you Request", HttpStatus.NOT_FOUND);
    }
}
