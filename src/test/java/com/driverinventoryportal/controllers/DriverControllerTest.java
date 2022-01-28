package com.driverinventoryportal.controllers;

import com.driverinventoryportal.models.Driver;
import com.driverinventoryportal.models.dto.DriverDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import javax.transaction.Transactional;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author PJ090169
 * This is the test class for testing Driver Controller class
 */
@Transactional
@SpringBootTest
class DriverControllerTest {

    @Autowired
    private DriverController driverController;

    /**
     * This method is testing addDriver method
     */
    @Test
    void testAddDriver() {
        ResponseEntity<DriverDto> testAddDriver = driverController.addDriver(new DriverDto("a","b","c","d","e","f",4,"g"));
        assertEquals("a",testAddDriver.getBody().getCommunicationProtocol());
        assertEquals("b",testAddDriver.getBody().getDriverType());
        assertEquals("c",testAddDriver.getBody().getVendor());
        assertEquals("d",testAddDriver.getBody().getModel());
        assertEquals("e",testAddDriver.getBody().getDescription());
        assertEquals("f",testAddDriver.getBody().getLatestJar());
        assertEquals(4,testAddDriver.getBody().getPackageNumber());
        assertEquals("g",testAddDriver.getBody().getGitHubRepository());
    }

    /**
     * This method is testing getDriver method
     */
    @Test
    void testGetDriver(){
        ResponseEntity<DriverDto> testAddDriver = driverController.addDriver(new DriverDto("a","b","c","d","e","f",4,"g"));
        Driver testDriverById = driverController.findDriverById(testAddDriver.getBody().getDriverId());
        assertEquals("a",testDriverById.getCommunicationProtocol());
        assertEquals("b",testDriverById.getDriverType());
        assertEquals("c",testDriverById.getVendor());
        assertEquals("d",testDriverById.getModel());
        assertEquals("e",testDriverById.getDescription());
        assertEquals("f",testDriverById.getLatestJar());
        assertEquals(4,testDriverById.getPackageNumber());
        assertEquals("g",testDriverById.getGitHubRepository());
    }

    /**
     * This method is testing updateDriver method
     */
    @Test
    void testUpdateDriver(){
        ResponseEntity<DriverDto> testAddDriver = driverController.addDriver(new DriverDto("a","b","c","d","e","f",4,"g"));
        ResponseEntity<DriverDto> testUpdateDriverResponse = driverController.updateDriverById(new DriverDto("x","y","z","q","w","e",5,"r"),testAddDriver.getBody().getDriverId());
        assertEquals("x",testUpdateDriverResponse.getBody().getCommunicationProtocol());
        assertEquals("y",testUpdateDriverResponse.getBody().getDriverType());
        assertEquals("z",testUpdateDriverResponse.getBody().getVendor());
        assertEquals("q",testUpdateDriverResponse.getBody().getModel());
        assertEquals("w",testUpdateDriverResponse.getBody().getDescription());
        assertEquals("e",testUpdateDriverResponse.getBody().getLatestJar());
        assertEquals(5,testUpdateDriverResponse.getBody().getPackageNumber());
        assertEquals("r",testUpdateDriverResponse.getBody().getGitHubRepository());
    }

    /**
     * This method is testing deleteDriver method
     */
    @Test
    void testDeleteDriver(){
        ResponseEntity<DriverDto> testAddDriver = driverController.addDriver(new DriverDto("a","b","c","d","e","f",4,"g"));
        Driver testDeleteResponse = driverController.deleteDriver(testAddDriver.getBody().getDriverId());
        assertEquals(testAddDriver.getBody().getDriverId(), testDeleteResponse.getDriverId());
    }

}
