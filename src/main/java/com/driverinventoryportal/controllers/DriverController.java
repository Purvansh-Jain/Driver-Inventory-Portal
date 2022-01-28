package com.driverinventoryportal.controllers;

import com.driverinventoryportal.models.Driver;
import com.driverinventoryportal.models.dto.DriverDto;
import com.driverinventoryportal.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.NoSuchElementException;

/**
 * @author PJ090169
 * This class is a controller layer for Driver Model
 */
@RestController
@RequestMapping("/api")
public class DriverController {
    @Autowired
    private DriverService driverService;


    /**
     * @param driverDto
     * @return Added Driver Details
     * Add driver details into database
     */
    @PostMapping("/addDriver")
    public ResponseEntity<DriverDto> addDriver(@Valid @RequestBody DriverDto driverDto){
        Driver driver = driverService.saveAndFlushDriver(Driver.from(driverDto));
        return new ResponseEntity<>(DriverDto.from(driver), HttpStatus.OK);
    }

    /**
     * @param driverId
     * @return Driver Details Fetched
     * Get driver details from database using driver id
     */
    @GetMapping("/driverById/{driverId}")
    public Driver findDriverById(@PathVariable long driverId) throws NoSuchElementException {
        return driverService.getDriverById(driverId); }

    /**
     *
     * @param driverDto
     * @param driverId
     * @return Driver Details Updated
     * Update existing driver model in database
     */
    @PutMapping("/updateDriver/{driverId}")
    public ResponseEntity<DriverDto> updateDriverById(@RequestBody DriverDto driverDto, @PathVariable long driverId){
        Driver updatedDriver = driverService.updateDriverById(driverId,Driver.from(driverDto));
        return new ResponseEntity<>(DriverDto.from(updatedDriver),HttpStatus.OK);
    }

    /**
     * @param driverId
     * @return Driver Is Deleted
     * Delete unwanted driver from database
     */
    @DeleteMapping("/deleteDriver/{driverId}")
    public Driver deleteDriver(@PathVariable long driverId){
        return driverService.deleteDriverById(driverId);
    }
}


