package com.driverinventoryportal.services;

import com.driverinventoryportal.models.Request;
import com.driverinventoryportal.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author PJ090169
 * This class is a  implementation of the RequestService Interface
 * This class will provide service to Driver Inventory Portal
 * It connects Controller with repository
 */
@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepository repository;

    /**
     * @param request
     * @return Request
     * Add request details to database
     */
    @Override
    public Request saveAndFlushRequest(Request request){
        return repository.save(request);
    }

    /**
     * @param requests
     * @return Requests
     * Add  multiple requests to database
     */
    @Override
    public List<Request> saveRequests(List<Request> requests){
        return repository.saveAll(requests);
    }

    /**
     * @return Fetched list of request
     * Get a complete list of request from database
     */
    @Override
    public List<Request> getRequests(){
        return repository.findAll();
    }

    /**
     * @param requestNumber
     * @return Fetched specific request details
     * Get detail of specific request from database using request number
     */
    @Override
    public  Request getRequestById(int requestNumber){
        return repository.findById(requestNumber).orElse(null);
    }

    /**
     * @param requestNumber
     * @return Deleted Request
     * Delete unwanted request from database
     *
     */
    @Override
    public Request deleteRequest(int requestNumber){
        Request request = getRequestById(requestNumber);
        repository.deleteById(requestNumber);
        return request;
    }

    /**
     * @param requestNumber
     * @param request
     * @return Updated Request Model
     * Update existing Request in database
     */
    @Override
    public Request updateRequestById(int requestNumber , Request request){
        Request existingRequest=repository.findById(requestNumber).orElse(null);
        if (existingRequest==null){
            throw new NullPointerException("Request can't be null");
        }
        existingRequest.setJiraType(request.getJiraType());
        existingRequest.setJiraStatus(request.getJiraStatus());
        existingRequest.setNotes(request.getNotes());
        return repository.save(existingRequest);
    }
}
