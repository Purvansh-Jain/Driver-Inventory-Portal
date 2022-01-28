package com.driverinventoryportal.services;

import com.driverinventoryportal.models.Request;
import java.util.List;

/**
 * @author PJ090169
 * This is interface for Request Service
 */
public interface RequestService {
    public Request saveAndFlushRequest(Request request);
    public List<Request> saveRequests(List<Request> requests);
    public List<Request> getRequests();
    public  Request getRequestById(int requestNumber);
    public Request deleteRequest(int requestNumber);
    public Request updateRequestById(int requestNumber , Request request);
}
