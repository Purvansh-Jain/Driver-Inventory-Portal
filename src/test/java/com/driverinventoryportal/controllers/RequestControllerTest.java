package com.driverinventoryportal.controllers;

import com.driverinventoryportal.models.Request;
import com.driverinventoryportal.models.dto.DriverDto;
import com.driverinventoryportal.models.dto.RequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author PJ090169
 * This is the test class for testing Request Controller class
 */
@Transactional
@SpringBootTest
class RequestControllerTest {
    @Autowired
    private RequestController requestController;

    @Autowired
    private DriverController driverController;


    /**
     * This method is testing addRequest method
     */
    @Test
    void testAddRequest() {
        ResponseEntity<RequestDto> testAddRequest = requestController.addRequest(new RequestDto("a","b","c"));
        assertEquals("a",testAddRequest.getBody().getJiraType());
        assertEquals("b",testAddRequest.getBody().getJiraStatus());
        assertEquals("c",testAddRequest.getBody().getNotes());
    }

    /**
     * This method is testing addRequests method
     */
    @Test
    void testAddRequests() {
        List<Request> requests = new ArrayList<>();
        requests.add(new Request("t", "f", "k"));
        requests.add(new Request("p", "q", "r"));
        requests.add(new Request("p", "m", "z"));
        List<Request> testAddRequests = requestController.addRequests(requests);
        assertEquals(3,testAddRequests.size() );
    }

    /**
     * This method is testing getListOfRequests method
     */
    @Test
    void testListOfRequests() {
        List<Request> requests = new ArrayList<>();
        requests.add(new Request("t", "f", "k"));
        requests.add(new Request("p", "q", "r"));
        requests.add(new Request("l", "m", "z"));
        List<Request> testAddRequests = requestController.addRequests(requests);
        List<Request> testRequestLists = requestController.findAllRequests();
        assertEquals("p",testRequestLists.get(1).getJiraType() );
        assertEquals("q",testRequestLists.get(1).getJiraStatus() );
        assertEquals("r",testRequestLists.get(1).getNotes() );
        assertEquals("t",testRequestLists.get(0).getJiraType());
        assertEquals("f",testRequestLists.get(0).getJiraStatus() );
        assertEquals("k",testRequestLists.get(0).getNotes() );
        assertEquals("l",testRequestLists.get(2).getJiraType() );
        assertEquals("m",testRequestLists.get(2).getJiraStatus() );
        assertEquals("z",testRequestLists.get(2).getNotes() );
    }

    /**
     * This method is testing getRequest method
     */
    @Test
    void testGetRequest() {
        ResponseEntity<RequestDto> testAddRequest = requestController.addRequest(new RequestDto("a","b","c"));
        Request testRequestById = requestController.findRequestById(testAddRequest.getBody().getRequestNumber());
        assertEquals("a",testRequestById.getJiraType() );
        assertEquals("b",testRequestById.getJiraStatus() );
        assertEquals("c",testRequestById.getNotes() );
    }

    /**
     * This method is testing updateRequest method
     */
    @Test
    void testUpdateRequest(){
        ResponseEntity<RequestDto> testAddRequest = requestController.addRequest(new RequestDto("a","b","c"));
        ResponseEntity<RequestDto> testUpdateRequestResponse = requestController.updateRequestById(new RequestDto("p","n","q"), testAddRequest.getBody().getRequestNumber());
        assertEquals("p",testUpdateRequestResponse.getBody().getJiraType());
        assertEquals("n",testUpdateRequestResponse.getBody().getJiraStatus());
        assertEquals("q",testUpdateRequestResponse.getBody().getNotes());
    }

    /**
     * This method is testing allocation of driverToRequest method
     */
    @Test
    void assignDriverToRequestTest(){
        ResponseEntity<DriverDto> testAddDriver = driverController.addDriver(new DriverDto("a","b","c","d","e","f",4,"g"));
        ResponseEntity<RequestDto> testAddRequest = requestController.addRequest(new RequestDto("a","b","c"));
        Request testAssignDriver = requestController.assignDriverToRequest(testAddRequest.getBody().getRequestNumber(), testAddDriver.getBody().getDriverId());
        assertEquals(testAddDriver.getBody().getDriverId(),testAssignDriver.getDriver().getDriverId());
        assertEquals(testAddDriver.getBody().getCommunicationProtocol(),testAssignDriver.getDriver().getCommunicationProtocol());
        assertEquals(testAddDriver.getBody().getDriverType(),testAssignDriver.getDriver().getDriverType());
        assertEquals(testAddDriver.getBody().getModel(),testAssignDriver.getDriver().getModel());
        assertEquals(testAddDriver.getBody().getDescription(),testAssignDriver.getDriver().getDescription());
        assertEquals(testAddDriver.getBody().getLatestJar(),testAssignDriver.getDriver().getLatestJar());
        assertEquals(testAddDriver.getBody().getPackageNumber(),testAssignDriver.getDriver().getPackageNumber());
        assertEquals(testAddDriver.getBody().getGitHubRepository(),testAssignDriver.getDriver().getGitHubRepository());
    }

    /**
     * This method is testing deleteRequest method
     */
    @Test
    void testDeleteRequest(){
        ResponseEntity<RequestDto> testAddRequest = requestController.addRequest(new RequestDto("a","b","c"));
        Request testDeleteResponse = requestController.deleteRequest(testAddRequest.getBody().getRequestNumber());
        assertEquals(testAddRequest.getBody().getRequestNumber(),testDeleteResponse.getRequestNumber() );
    }

}



