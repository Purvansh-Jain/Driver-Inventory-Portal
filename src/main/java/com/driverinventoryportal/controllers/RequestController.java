package com.driverinventoryportal.controllers;

import com.driverinventoryportal.models.Request;
import com.driverinventoryportal.models.Driver;
import com.driverinventoryportal.models.dto.RequestDto;
import com.driverinventoryportal.repositories.RequestRepository;
import com.driverinventoryportal.repositories.DriverRepository;
import com.driverinventoryportal.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author PJ090169
 * This class s a controller layer for Request Model
 */
@RestController
@RequestMapping("/api")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private RequestRepository requestRepository;

    /**
     * @param requestDto
     * @return Added Request Details
     * Add request details to database
     */
    @PostMapping(value = "/addRequest")
    public ResponseEntity<RequestDto> addRequest(@RequestBody RequestDto requestDto){
        Request request = requestService.saveAndFlushRequest(Request.from(requestDto));
        return new ResponseEntity<>(RequestDto.from(request), HttpStatus.OK);
    }

    /**
     * @param requests
     * @return Added List of Requests Details
     * Add  multiple requests to database
     */
    @PostMapping("/addRequests")
    public List<Request> addRequests(@RequestBody List<Request> requests){
        return requestService.saveRequests(requests); }

    /**
     * @return Fetched list of request
     * Get a complete list of request from database
     */
    @GetMapping("/requests")
    public List<Request> findAllRequests(){
        return requestService.getRequests();
    }

    /**
     * @return Fetched specific request details
     * Get detail of specific request from database using request number
     */
    @GetMapping("/requestById/{requestNumber}")
    public Request findRequestById(@PathVariable int requestNumber){
        return requestService.getRequestById(requestNumber); }

    /**
     * @param requestDto
     * @param requestNumber
     * @return Updated Request Model
     * Update existing Request in database
     */
    @PutMapping("/updateRequest/{requestNumber}")
    public ResponseEntity<RequestDto> updateRequestById(@RequestBody RequestDto requestDto, @PathVariable int requestNumber){
        Request updatedRequest = requestService.updateRequestById(requestNumber,Request.from(requestDto));
        return new ResponseEntity<>(RequestDto.from(updatedRequest),HttpStatus.OK);
    }

    /**
     *
     * @param requestNumber
     * @param driverId
     * @return Fetched Request of assigned driver to it
     * Get details of request and driver model by specifying request number and driver id
     */
    @PutMapping("/{requestNumber}/driver/{driverId}")
    public Request assignDriverToRequest(
            @PathVariable int requestNumber,
            @PathVariable long driverId)
    {
        Request request = requestRepository.findById(requestNumber).orElse(null);
        if (request==null){
            throw new NullPointerException("Request can't be null");
        }
        Driver driver = driverRepository.findById(driverId).orElse(null);
        request.assignDriver(driver);
        return requestRepository.save(request); }

    /**
     * @param requestNumber
     * @return Deleted Request
     * Delete unwanted request from database
     */
    @DeleteMapping("/deleteRequest/{requestNumber}")
    public Request deleteRequest(@PathVariable int requestNumber){
        return requestService.deleteRequest(requestNumber);
    }
}
